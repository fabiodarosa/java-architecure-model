package com.fabiodarosa.architecture.ports.out.database;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface SubscriptionDatabasePort {

  SubscriptionSaved updateSubscription(UpdateSubscriptionCommand command);

  void createSubscriptionEventHistory(CreateEventLogCommand command);

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class UpdateSubscriptionCommand {

    private String id;
    private String status;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class CreateEventLogCommand {

    private String subscriptionId;
    private SubscriptionStatusSaved status;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class SubscriptionSaved {

    private String subscriptionId;
    private LocalDateTime createdAt;
    private Timestamp updatedAt;
    private SubscriptionStatusSaved status;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class SubscriptionStatusSaved {

    private int id;
    private String name;
  }

}
