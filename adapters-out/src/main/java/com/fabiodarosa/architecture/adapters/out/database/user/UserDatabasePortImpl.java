package com.fabiodarosa.architecture.adapters.out.database.user;

import com.fabiodarosa.architecture.ports.out.database.UserDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDatabasePortImpl implements UserDatabasePort {

  private final UserRepository userRepository;
  private final DatabaseUserMapper mapper;

  @Override
  public InsertUserReturn insertUser(InsertUserDatabaseCommand command) {
    System.out.println(command);
    return mapper.mapToReturn(userRepository.save(mapper.mapToEntity(command)));
  }
}
