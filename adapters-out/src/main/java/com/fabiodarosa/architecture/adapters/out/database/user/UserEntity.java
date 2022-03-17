package com.fabiodarosa.architecture.adapters.out.database.user;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {

  @Id
  @Column(unique = true, updatable = false, nullable = false)
  private String cpf;

  private String name;
  private String email;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
