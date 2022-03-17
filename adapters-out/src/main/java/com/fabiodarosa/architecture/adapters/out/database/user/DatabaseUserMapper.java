package com.fabiodarosa.architecture.adapters.out.database.user;

import com.fabiodarosa.architecture.ports.out.database.UserDatabasePort.InsertUserDatabaseCommand;
import com.fabiodarosa.architecture.ports.out.database.UserDatabasePort.InsertUserReturn;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DatabaseUserMapper {

  @Mapping(target = "createdAt", ignore = true)
  UserEntity mapToEntity(InsertUserDatabaseCommand command);

  InsertUserReturn mapToReturn(UserEntity entity);
}
