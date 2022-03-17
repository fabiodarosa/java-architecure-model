package com.fabiodarosa.architecture.domain.service.database;

import com.fabiodarosa.architecture.domain.mappers.ports.database.UserDatabasePortMapper;
import com.fabiodarosa.architecture.domain.model.User;
import com.fabiodarosa.architecture.ports.out.database.UserDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDatabaseService {

  private final UserDatabasePort port;
  private final UserDatabasePortMapper mapper;

  public User createUser(User user) {
    return mapper.mapToModel(port.insertUser(mapper.mapToInsertUserCommand(user)));

  }


}
