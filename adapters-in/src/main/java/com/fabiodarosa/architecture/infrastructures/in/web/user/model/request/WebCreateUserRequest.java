package com.fabiodarosa.architecture.infrastructures.in.web.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WebCreateUserRequest {

  private String name;
  private String cpf;
  private String email;

}
