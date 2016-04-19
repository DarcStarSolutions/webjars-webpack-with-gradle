package org.darcstarsolutions.examples.webjars

import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.stereotype.Component
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry

/**
 * Created by mharris on 4/19/16.
 */

@Component
@EnableWebSocketMessageBroker
class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer{


    public static final String MESSAGE_PREFIX = "/topic"

    @Override
    void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/payroll").withSockJS()
    }

    @Override
    void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(MESSAGE_PREFIX)
        registry.setApplicationDestinationPrefixes("/app")
    }
}
