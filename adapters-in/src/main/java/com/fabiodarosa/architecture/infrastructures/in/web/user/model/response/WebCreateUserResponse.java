package com.fabiodarosa.architecture.infrastructures.in.web.user.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WebCreateUserResponse {

  private String name;
  private String cpf;
  private String email;
}
