package com.fabiodarosa.architecture.adapters.out.messaging.user;

import com.fabiodarosa.architecture.ports.out.messaging.UserMessagingPort;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserMessagingPortImpl implements UserMessagingPort {

  private final RabbitTemplate rabbitTemplate;

  @Value("${messaging.user.user-created}")
  private String queueName;

  @Override
  public void createUser(UserCreatedProducerPayload payload) {
    rabbitTemplate.convertAndSend(queueName, queueName, payload);
  }
}
