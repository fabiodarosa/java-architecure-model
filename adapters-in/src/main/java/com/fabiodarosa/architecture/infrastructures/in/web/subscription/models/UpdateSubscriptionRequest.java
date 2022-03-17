package com.fabiodarosa.architecture.infrastructures.in.web.subscription.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateSubscriptionRequest {

  private String userId;
  private String status;

}
