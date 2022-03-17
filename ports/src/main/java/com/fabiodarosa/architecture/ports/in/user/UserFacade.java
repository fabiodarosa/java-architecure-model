package com.fabiodarosa.architecture.ports.in.user;

import com.fabiodarosa.architecture.ports.in.user.CreateUserPort.CreateUserCommand;
import com.fabiodarosa.architecture.ports.in.user.CreateUserPort.CreateUserReturn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

  private final CreateUserPort createUserPort;


  public CreateUserReturn createUser(CreateUserCommand command) {
    return createUserPort.call(command);
  }

}
