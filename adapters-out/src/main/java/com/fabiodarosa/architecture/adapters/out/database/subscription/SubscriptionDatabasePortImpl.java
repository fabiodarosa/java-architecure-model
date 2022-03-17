package com.fabiodarosa.architecture.adapters.out.database.subscription;

import com.fabiodarosa.architecture.adapters.out.database.subscription.eventhistory.SubscriptionEventHistoryRepository;
import com.fabiodarosa.architecture.adapters.out.database.subscription.status.SubscriptionStatusEntity;
import com.fabiodarosa.architecture.adapters.out.database.subscription.status.SubscriptionStatusRepository;
import com.fabiodarosa.architecture.adapters.out.database.subscription.subscription.SubscriptionRepository;
import com.fabiodarosa.architecture.ports.out.database.SubscriptionDatabasePort;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionDatabasePortImpl implements SubscriptionDatabasePort {

  private final SubscriptionRepository subscriptionRepository;
  private final SubscriptionStatusRepository statusRepository;
  private final SubscriptionEventHistoryRepository eventHistoryRepository;
  private final DatabaseSubscriptionMapper mapper;
  private final EntityManager entityManager;


  @Override
  public SubscriptionSaved updateSubscription(UpdateSubscriptionCommand command) {
    SubscriptionStatusEntity status = statusRepository.findByName(command.getStatus())
        .orElseThrow(() -> new RuntimeException(command.getStatus() + " Not found"));

    return mapper.mapToSaved(subscriptionRepository.save(mapper.mapToSubscriptionEntity(command, status)));
  }

  @Override
  public void createSubscriptionEventHistory(CreateEventLogCommand command) {
    eventHistoryRepository.save(mapper.mapToEventHistoryEntity(command));
  }
}
