package com.fabiodarosa.architecture.adapters.out.database;

import com.fabiodarosa.architecture.adapters.out.database.subscription.status.SubscriptionStatusEntity;
import com.fabiodarosa.architecture.adapters.out.database.subscription.status.SubscriptionStatusRepository;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@Slf4j
public class PopulateDatabase {

  private final SubscriptionStatusRepository statusRepository;

  @PostConstruct
  void insertStatus() {
    statusRepository.findByName("SUBSCRIPTION_PURCHASED")
        .ifPresentOrElse((status) -> log.info(status.getName() + " already exists"),
            () -> statusRepository.save(SubscriptionStatusEntity.builder().name("SUBSCRIPTION_PURCHASED").build()));
    statusRepository.findByName("SUBSCRIPTION_CANCELED")
        .ifPresentOrElse((status) -> log.info(status.getName() + " already exists"),
            () -> statusRepository.save(SubscriptionStatusEntity.builder().name("SUBSCRIPTION_CANCELED").build()));
    statusRepository.findByName("SUBSCRIPTION_RESTARTED")
        .ifPresentOrElse((status) -> log.info(status.getName() + " already exists"),
            () -> statusRepository.save(SubscriptionStatusEntity.builder().name("SUBSCRIPTION_RESTARTED").build()));
    statusRepository.findByName("SUBSCRIPTION_RESTARTED")
        .ifPresentOrElse((status) -> log.info(status.getName() + " already exists"),
            () -> statusRepository.save(SubscriptionStatusEntity.builder().name("SUBSCRIPTION_RESTARTED").build()));
    statusRepository.findByName("SUBSCRIPTION_RESTARTED")
        .ifPresentOrElse((status) -> log.info(status.getName() + " already exists"),
            () -> statusRepository.save(SubscriptionStatusEntity.builder().name("SUBSCRIPTION_INACTIVE").build()));
  }

}
