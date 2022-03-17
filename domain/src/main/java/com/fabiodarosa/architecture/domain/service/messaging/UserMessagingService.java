package com.fabiodarosa.architecture.domain.service.messaging;

import com.fabiodarosa.architecture.domain.mappers.ports.messaging.UserMessagingPortMapper;
import com.fabiodarosa.architecture.domain.model.User;
import com.fabiodarosa.architecture.ports.out.messaging.UserMessagingPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMessagingService {

  private final UserMessagingPort port;
  private final UserMessagingPortMapper mapper;

  public void userCreatedProduce(User user) {
    port.createUser(mapper.mapToUserCreatedMessagingPayload(user));
  }

}
