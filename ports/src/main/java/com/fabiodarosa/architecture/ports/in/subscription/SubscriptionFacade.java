package com.fabiodarosa.architecture.ports.in.subscription;

import com.fabiodarosa.architecture.ports.in.subscription.RequestToUpdateSubscriptionPort.RequestToCreateSubscriptionCommand;
import com.fabiodarosa.architecture.ports.in.subscription.SaveSubscriptionPort.SaveSubscriptionCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SubscriptionFacade {

  private final RequestToUpdateSubscriptionPort requestToUpdateSubscriptionPort;
  private final SaveSubscriptionPort saveSubscriptionPort;

  public void requestToUpdateSubscription(RequestToCreateSubscriptionCommand command) {
    requestToUpdateSubscriptionPort.call(command);
  }

  public void saveSubscription(SaveSubscriptionCommand command) {
    saveSubscriptionPort.call(command);
  }

}
