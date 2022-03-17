package com.fabiodarosa.architecture.adapters.out.database.subscription;

import com.fabiodarosa.architecture.adapters.out.database.subscription.eventhistory.SubscriptionEventHistoryEntity;
import com.fabiodarosa.architecture.adapters.out.database.subscription.status.SubscriptionStatusEntity;
import com.fabiodarosa.architecture.adapters.out.database.subscription.subscription.SubscriptionEntity;
import com.fabiodarosa.architecture.ports.out.database.SubscriptionDatabasePort.CreateEventLogCommand;
import com.fabiodarosa.architecture.ports.out.database.SubscriptionDatabasePort.SubscriptionSaved;
import com.fabiodarosa.architecture.ports.out.database.SubscriptionDatabasePort.UpdateSubscriptionCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DatabaseSubscriptionMapper {

  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "status", source = "status")
  @Mapping(target = "subscriptionId", source = "command.id")
  SubscriptionEntity mapToSubscriptionEntity(UpdateSubscriptionCommand command, SubscriptionStatusEntity status);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "type", source = "status")
  @Mapping(target = "subscription.subscriptionId", source = "subscriptionId")
  SubscriptionEventHistoryEntity mapToEventHistoryEntity(CreateEventLogCommand command);

  SubscriptionSaved mapToSaved(SubscriptionEntity entity);

}
