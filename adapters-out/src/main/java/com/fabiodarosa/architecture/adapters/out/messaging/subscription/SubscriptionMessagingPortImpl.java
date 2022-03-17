package com.fabiodarosa.architecture.adapters.out.messaging.subscription;

import com.fabiodarosa.architecture.ports.out.messaging.SubscriptionMessagingPort;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionMessagingPortImpl implements SubscriptionMessagingPort {

  private final RabbitTemplate rabbitTemplate;

  @Value("${messaging.subscription.update-subscription}")
  private String queueName;

  @Override
  public void requestToCreateSubscription(RequestToCreateSubscriptionProducerPayload payload) {
    rabbitTemplate.convertAndSend(queueName, queueName, payload);
  }
}
