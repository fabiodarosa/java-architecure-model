package com.fabiodarosa.architecture.domain.mappers.ports.database;

import com.fabiodarosa.architecture.domain.model.Subscription;
import com.fabiodarosa.architecture.ports.out.database.SubscriptionDatabasePort.CreateEventLogCommand;
import com.fabiodarosa.architecture.ports.out.database.SubscriptionDatabasePort.SubscriptionSaved;
import com.fabiodarosa.architecture.ports.out.database.SubscriptionDatabasePort.UpdateSubscriptionCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriptionDatabasePortMapper {

  @Mapping(target = "status",source = "status.name")
  UpdateSubscriptionCommand mapToUpdateSubscriptionCommand(Subscription subscription);

  CreateEventLogCommand mapToCreateEventLogCommand(SubscriptionSaved subscription);


}
