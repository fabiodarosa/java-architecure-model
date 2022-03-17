package com.fabiodarosa.architecture.domain.usecase.subscription;

import com.fabiodarosa.architecture.domain.model.Subscription;
import com.fabiodarosa.architecture.domain.service.messaging.SubscriptionMessagingService;
import com.fabiodarosa.architecture.ports.in.subscription.RequestToUpdateSubscriptionPort;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestToCreateSubscriptionUC implements RequestToUpdateSubscriptionPort {

  private final SubscriptionMessagingService messagingService;

  @Override
  public void call(RequestToCreateSubscriptionCommand command) {
    mapToModel()
        .andThen(produceRequestToUpdateSubscriptionMessage())
        .apply(command);
  }

  Function<RequestToCreateSubscriptionCommand, Subscription> mapToModel() {
    return UseCaseMapper.INSTANCE::mapToModel;
  }

  UnaryOperator<Subscription> produceRequestToUpdateSubscriptionMessage() {
    return subscription -> {
      messagingService.requestToUpdateSubscription(subscription);
      return subscription;
    };
  }


  @Mapper
  interface UseCaseMapper {

    UseCaseMapper INSTANCE = Mappers.getMapper(UseCaseMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "status.name", source = "status")
    @Mapping(target = "user.cpf", source = "userCpf")
    Subscription mapToModel(RequestToCreateSubscriptionCommand command);

  }

}
