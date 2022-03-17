package com.fabiodarosa.architecture.ports.out.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface SubscriptionMessagingPort {

  void requestToCreateSubscription(RequestToCreateSubscriptionProducerPayload payload);

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class RequestToCreateSubscriptionProducerPayload {

    String userCpf;
    String status;
  }

}
