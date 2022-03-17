package com.fabiodarosa.architecture.domain.service.messaging;

import com.fabiodarosa.architecture.domain.mappers.ports.messaging.SubscriptionMessagingPortMapper;
import com.fabiodarosa.architecture.domain.model.Subscription;
import com.fabiodarosa.architecture.ports.out.messaging.SubscriptionMessagingPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionMessagingService {

  private final SubscriptionMessagingPort port;
  private final SubscriptionMessagingPortMapper mapper;

  public void requestToUpdateSubscription(Subscription subscription) {
    port.requestToCreateSubscription(mapper.mapToRequestToCreateSubscriptionPayload(subscription));
  }

}
