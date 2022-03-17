package com.fabiodarosa.architecture.domain.mappers.ports.messaging;

import com.fabiodarosa.architecture.domain.model.User;
import com.fabiodarosa.architecture.ports.out.messaging.UserMessagingPort.UserCreatedProducerPayload;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMessagingPortMapper {

  UserCreatedProducerPayload mapToUserCreatedMessagingPayload(User user);


}
