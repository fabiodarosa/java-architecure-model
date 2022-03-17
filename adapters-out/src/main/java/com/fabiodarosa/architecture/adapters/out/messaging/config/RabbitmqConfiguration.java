package com.fabiodarosa.architecture.adapters.out.messaging.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {

  @Bean
  DirectExchange deadLetterExchange() {
    return new DirectExchange("update-subscription-dlq");
  }

  @Bean
  DirectExchange exchange() {
    return new DirectExchange("update-subscription");
  }

  @Bean
  Queue dlq() {
    return QueueBuilder.durable("update-subscription-dlq.queue").build();
  }

  @Bean
  Queue queue() {
    return QueueBuilder.durable("update-subscription.queue").withArgument("x-dead-letter-exchange", "update-subscription-dlq")
        .withArgument("x-dead-letter-routing-key", "deadLetter").build();
  }

  @Bean
  Binding DLQbinding() {
    return BindingBuilder.bind(dlq()).to(deadLetterExchange()).with("deadLetter");
  }

  @Bean
  Binding binding() {
    return BindingBuilder.bind(queue()).to(exchange()).with("update-subscription");
  }

  @Bean
  public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
    final var rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
    return rabbitTemplate;
  }

  @Bean
  public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

}
