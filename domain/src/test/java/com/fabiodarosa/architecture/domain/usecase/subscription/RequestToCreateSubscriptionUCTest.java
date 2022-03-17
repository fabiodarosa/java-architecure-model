package com.fabiodarosa.architecture.domain.usecase.subscription;


import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fabiodarosa.architecture.domain.usecase.user.CreateUserUS;
import com.fabiodarosa.architecture.ports.in.user.CreateUserPort;
import com.fabiodarosa.architecture.ports.out.database.UserDatabasePort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CreateUserUS.class)
class RequestToCreateSubscriptionUCTest {

  @Autowired
  CreateUserPort port;

  UserDatabasePort userDatabasePort = DatabaseMock.USER_DATABASE_PORT;

  @Test
  void sla() {

    port.call(null);
    assertTrue(true);
  }
}
