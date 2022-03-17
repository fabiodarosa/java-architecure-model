package com.fabiodarosa.architecture.ports.out.database;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface UserDatabasePort {

  InsertUserReturn insertUser(InsertUserDatabaseCommand command);

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class InsertUserDatabaseCommand {

    private String name;
    private String cpf;
    private String email;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  class InsertUserReturn {

    private String name;
    private String cpf;
    private String email;
  }

}
