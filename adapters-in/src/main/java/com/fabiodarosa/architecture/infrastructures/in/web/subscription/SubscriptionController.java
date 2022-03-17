package com.fabiodarosa.architecture.infrastructures.in.web.subscription;

import com.fabiodarosa.architecture.infrastructures.in.web.subscription.models.UpdateSubscriptionRequest;
import com.fabiodarosa.architecture.ports.in.subscription.SubscriptionFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/subscription")
@AllArgsConstructor
public class SubscriptionController {

  private final SubscriptionFacade facade;
  private final WebSubscriptionMapper mapper;

  @PatchMapping("")
  public void updateSubscription(@RequestBody UpdateSubscriptionRequest requestBody) {
    facade.requestToUpdateSubscription(mapper.mapToCommand(requestBody));
  }

}
