package com.fabiodarosa.architecture.domain.usecase.subscription;

import com.fabiodarosa.architecture.domain.model.Subscription;
import com.fabiodarosa.architecture.domain.service.database.SubscriptionDatabaseService;
import com.fabiodarosa.architecture.ports.in.subscription.SaveSubscriptionPort;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveSubscriptionUC implements SaveSubscriptionPort {

  private final SubscriptionDatabaseService subscriptionDatabaseService;

  @Override
  public void call(SaveSubscriptionCommand command) {
    mapToModel()
        .andThen(updateSubscriptionOnDatabase())
        .apply(command);
  }

  Function<SaveSubscriptionCommand, Subscription> mapToModel() {
    return UseCaseMapper.INSTANCE::mapToModel;
  }

  UnaryOperator<Subscription> updateSubscriptionOnDatabase() {
    return subscription -> {
      subscriptionDatabaseService.updateSubscription(subscription);
      return subscription;
    };
  }

  @Mapper
  interface UseCaseMapper {

    UseCaseMapper INSTANCE = Mappers.getMapper(UseCaseMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status.name", source = "status")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Subscription mapToModel(SaveSubscriptionCommand command);

  }
}
