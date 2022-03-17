package com.fabiodarosa.architecture.infrastructures.in.web.user;

import com.fabiodarosa.architecture.infrastructures.in.web.user.model.request.WebCreateUserRequest;
import com.fabiodarosa.architecture.infrastructures.in.web.user.model.response.WebCreateUserResponse;
import com.fabiodarosa.architecture.ports.in.user.UserFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@AllArgsConstructor
public class UserController {

  private final UserFacade userFacade;
  private final WebUserMapper userMapper;

  @PostMapping
  public WebCreateUserResponse createUser(@RequestBody WebCreateUserRequest requestBody) {
    return userMapper.mapToResponse(userFacade.createUser(userMapper.mapToCommand(requestBody)));
  }

}
