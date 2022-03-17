package com.fabiodarosa.architecture.domain.mappers.ports.messaging;

import com.fabiodarosa.architecture.domain.model.Subscription;
import com.fabiodarosa.architecture.ports.out.messaging.SubscriptionMessagingPort.RequestToCreateSubscriptionProducerPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriptionMessagingPortMapper {


  @Mapping(target = "status", source = "status.name")
  @Mapping(target = "userCpf", source = "user.cpf")
  RequestToCreateSubscriptionProducerPayload mapToRequestToCreateSubscriptionPayload(Subscription command);

}
