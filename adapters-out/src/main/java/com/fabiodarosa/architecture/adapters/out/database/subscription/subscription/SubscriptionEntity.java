package com.fabiodarosa.architecture.adapters.out.database.subscription.subscription;

import com.fabiodarosa.architecture.adapters.out.database.subscription.status.SubscriptionStatusEntity;
import com.fabiodarosa.architecture.adapters.out.database.user.UserEntity;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name = "Subscription")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubscriptionEntity {

  @Id
  @Column(name = "id")
  private String subscriptionId;

  @Column(name = "created_at", updatable = false, nullable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  @UpdateTimestamp
  private Timestamp updatedAt;

  @ManyToOne
  @JoinColumn(name = "status_id", nullable = false)
  private SubscriptionStatusEntity status;

  @OneToOne
  @JoinColumn(name = "cpf", nullable = false)
  private UserEntity user;

}
