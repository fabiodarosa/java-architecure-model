package com.fabiodarosa.architecture.adapters.out.database.subscription.eventhistory;

import com.fabiodarosa.architecture.adapters.out.database.subscription.status.SubscriptionStatusEntity;
import com.fabiodarosa.architecture.adapters.out.database.subscription.subscription.SubscriptionEntity;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

@Table(name = "EventHistory")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class SubscriptionEventHistoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "status_id", nullable = false)
  private SubscriptionStatusEntity type;

  @ManyToOne
  @JoinColumn(name = "subscription_id", nullable = false, updatable = false)
  private SubscriptionEntity subscription;

  @Column(name = "created_at", nullable = false, updatable = false)
  @CreationTimestamp
  private Timestamp createdAt;


}
