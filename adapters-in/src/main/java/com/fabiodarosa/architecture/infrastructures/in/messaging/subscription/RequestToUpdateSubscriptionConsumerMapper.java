package com.fabiodarosa.architecture.infrastructures.in.messaging.subscription;

import com.fabiodarosa.architecture.infrastructures.in.messaging.subscription.model.UpdateSubscriptionConsumerPayload;
import com.fabiodarosa.architecture.ports.in.subscription.SaveSubscriptionPort.SaveSubscriptionCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RequestToUpdateSubscriptionConsumerMapper {


  @Mapping(target = "userId", source = "subscriptionId")
  @Mapping(target = "status", source = "notificationType")
  SaveSubscriptionCommand mapToCommand(UpdateSubscriptionConsumerPayload consumerModel);

}
