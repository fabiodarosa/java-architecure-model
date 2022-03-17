package com.fabiodarosa.architecture.adapters.out.database.subscription.eventhistory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionEventHistoryRepository extends CrudRepository<SubscriptionEventHistoryEntity, Integer> {

}
