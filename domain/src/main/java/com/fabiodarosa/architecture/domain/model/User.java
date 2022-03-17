package com.fabiodarosa.architecture.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

  private String name;
  private String cpf;
  private String email;
  private LocalDateTime createdAt;

}
