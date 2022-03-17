package com.fabiodarosa.architecture.domain.mappers.ports.database;

import com.fabiodarosa.architecture.domain.model.User;
import com.fabiodarosa.architecture.ports.out.database.UserDatabasePort.InsertUserDatabaseCommand;
import com.fabiodarosa.architecture.ports.out.database.UserDatabasePort.InsertUserReturn;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDatabasePortMapper {

  User mapToModel(InsertUserReturn returns);

  InsertUserDatabaseCommand mapToInsertUserCommand(User user);


}
