package com.fabiodarosa.architecture.ports.in.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface CreateUserPort {

  CreateUserReturn call(CreateUserCommand command);

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class CreateUserCommand {

    private String name;
    private String cpf;
    private String email;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class CreateUserReturn {

    private String name;
    private String cpf;
    private String email;
  }

}
