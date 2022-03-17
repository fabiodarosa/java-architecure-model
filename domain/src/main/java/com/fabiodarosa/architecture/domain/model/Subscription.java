package com.fabiodarosa.architecture.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subscription {

  private String id;
  private SubscriptionStatus status;
  private User user;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}
