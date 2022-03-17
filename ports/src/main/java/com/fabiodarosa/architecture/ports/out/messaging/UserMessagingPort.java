package com.fabiodarosa.architecture.ports.out.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface UserMessagingPort {

  void createUser(UserCreatedProducerPayload payload);

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class UserCreatedProducerPayload {

    private String name;
    private String email;
  }

}
