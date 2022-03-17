package com.fabiodarosa.architecture.ports.in.subscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface SaveSubscriptionPort {

  void call(SaveSubscriptionCommand command);

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class SaveSubscriptionCommand {

    private String userId;
    private String status;
  }
}
