package com.fabiodarosa.architecture.domain.service.database;

import com.fabiodarosa.architecture.domain.mappers.ports.database.SubscriptionDatabasePortMapper;
import com.fabiodarosa.architecture.domain.model.Subscription;
import com.fabiodarosa.architecture.ports.out.database.SubscriptionDatabasePort;
import com.fabiodarosa.architecture.ports.out.database.SubscriptionDatabasePort.SubscriptionSaved;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SubscriptionDatabaseService {

  private final SubscriptionDatabasePort port;
  private final SubscriptionDatabasePortMapper mapper;


  public void updateSubscription(final Subscription subscriptionParam) {
    SubscriptionSaved subscriptionSaved = port.updateSubscription(mapper.mapToUpdateSubscriptionCommand(subscriptionParam));

    port.createSubscriptionEventHistory(mapper.mapToCreateEventLogCommand(subscriptionSaved));
  }

}
