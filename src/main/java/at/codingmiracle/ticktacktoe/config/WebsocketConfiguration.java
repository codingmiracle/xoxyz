package at.codingmiracle.ticktacktoe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfiguration implements WebSocketMessageBrokerConfigurer {
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/move").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app").enableSimpleBroker("/topic");
	}
}

/**
 *	@EnableWebSocketMessageBroker : It enables WebSocket message handling, backed by a message broker. Here we are using STOMP as a message broker.
 *
 * The method configureMessageBroker() enables a simple memory-based message broker to carry the messages back to the client on destinations prefixed with “/topic” and also defines the prefix “/app” that is used to filter destinations handled The controller, after processing the message, will send it to the broker.
 *
 * Similarly,registerStompEndpoints() enables STOMP support and registers stomp endpoints at “/sow”. Doing so, all the WebSocket messages will be channelized through STOMP and this also adds an extra layer of security to the WebSocket endpoint
 */
