package com.fabiodarosa.architecture.infrastructures.in.messaging.subscription.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateSubscriptionConsumerPayload {

  String subscriptionId;
  String notificationType;

}
