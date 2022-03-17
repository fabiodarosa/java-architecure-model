package com.fabiodarosa.architecture.infrastructures.in.web.subscription;

import com.fabiodarosa.architecture.infrastructures.in.web.subscription.models.UpdateSubscriptionRequest;
import com.fabiodarosa.architecture.ports.in.subscription.RequestToUpdateSubscriptionPort.RequestToCreateSubscriptionCommand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WebSubscriptionMapper {

  RequestToCreateSubscriptionCommand mapToCommand(UpdateSubscriptionRequest request);
}
