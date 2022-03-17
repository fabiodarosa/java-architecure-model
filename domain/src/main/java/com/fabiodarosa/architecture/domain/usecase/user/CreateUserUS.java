package com.fabiodarosa.architecture.domain.usecase.user;


import com.fabiodarosa.architecture.domain.model.User;
import com.fabiodarosa.architecture.domain.service.database.UserDatabaseService;
import com.fabiodarosa.architecture.domain.service.messaging.UserMessagingService;
import com.fabiodarosa.architecture.ports.in.user.CreateUserPort;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserUS implements CreateUserPort {

  private final UserDatabaseService userDatabase;
  private final UserMessagingService userMessaging;

  @Override
  public CreateUserReturn call(CreateUserCommand command) {
    return mapToModel()
        .andThen(saveOnDatabase())
        .andThen(publishUserCreatedMessage())
        .andThen(mapToReturn())
        .apply(command);
  }

  Function<CreateUserCommand, User> mapToModel() {
    return UseCaseMapper.INSTANCE::mapToModel;
  }

  UnaryOperator<User> saveOnDatabase() {
    return userDatabase::createUser;
  }

  UnaryOperator<User> publishUserCreatedMessage() {
    return user -> {
      userMessaging.userCreatedProduce(user);
      return user;
    };
  }

  Function<User, CreateUserReturn> mapToReturn() {
    return UseCaseMapper.INSTANCE::mapToCreateUserReturn;
  }

  @Mapper
  interface UseCaseMapper {

    UseCaseMapper INSTANCE = Mappers.getMapper(UseCaseMapper.class);

    CreateUserReturn mapToCreateUserReturn(User user);

    @Mapping(target = "createdAt", ignore = true)
    User mapToModel(CreateUserCommand command);

  }

}

