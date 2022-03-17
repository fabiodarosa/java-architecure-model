package com.fabiodarosa.architecture.adapters.out.database.subscription.status;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionStatusRepository extends CrudRepository<SubscriptionStatusEntity, Integer> {

  Optional<SubscriptionStatusEntity> findByName(String name);
}
