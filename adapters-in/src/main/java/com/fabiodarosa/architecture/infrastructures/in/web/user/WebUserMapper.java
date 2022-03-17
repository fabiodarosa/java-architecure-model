package com.fabiodarosa.architecture.infrastructures.in.web.user;

import com.fabiodarosa.architecture.infrastructures.in.web.user.model.request.WebCreateUserRequest;
import com.fabiodarosa.architecture.infrastructures.in.web.user.model.response.WebCreateUserResponse;
import com.fabiodarosa.architecture.ports.in.user.CreateUserPort.CreateUserCommand;
import com.fabiodarosa.architecture.ports.in.user.CreateUserPort.CreateUserReturn;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WebUserMapper {

  CreateUserCommand mapToCommand(WebCreateUserRequest requestBody);

  WebCreateUserResponse mapToResponse(CreateUserReturn domainResponse);

}
