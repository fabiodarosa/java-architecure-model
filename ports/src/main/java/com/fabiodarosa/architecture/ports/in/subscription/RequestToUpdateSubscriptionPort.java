package com.fabiodarosa.architecture.ports.in.subscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface RequestToUpdateSubscriptionPort {


  void call(RequestToCreateSubscriptionCommand command);

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class RequestToCreateSubscriptionCommand {

    private String userCpf;
    private String status;
  }

}
