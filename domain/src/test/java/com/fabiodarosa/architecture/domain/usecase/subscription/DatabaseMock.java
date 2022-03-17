package com.fabiodarosa.architecture.domain.usecase.subscription;

import com.fabiodarosa.architecture.ports.out.database.UserDatabasePort;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseMock {

  public static final UserDatabasePort USER_DATABASE_PORT = Mockito.mock(UserDatabasePort.class);

  @Bean
  UserDatabasePort userDatabasePort() {
    return USER_DATABASE_PORT;
  }

}
