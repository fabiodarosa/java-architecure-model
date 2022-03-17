package com.fabiodarosa.architecture.infrastructures.in.messaging.subscription;

import com.fabiodarosa.architecture.infrastructures.in.messaging.subscription.model.UpdateSubscriptionConsumerPayload;
import com.fabiodarosa.architecture.ports.in.subscription.SubscriptionFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Slf4j
public class RequestToUpdateSubscriptionConsumer {

  private final SubscriptionFacade subscriptionFacade;
  private final RequestToUpdateSubscriptionConsumerMapper mapper;

  @RabbitListener(queues = "${messaging.subscription.update-subscription}.queue",
      concurrency = "7",
      autoStartup = "true",
      exclusive = false)
  public void handleMessage(UpdateSubscriptionConsumerPayload updateSubscriptionModel) {
    subscriptionFacade.saveSubscription(mapper.mapToCommand(updateSubscriptionModel));
  }

}
