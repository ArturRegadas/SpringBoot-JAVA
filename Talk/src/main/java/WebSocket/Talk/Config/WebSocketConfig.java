package WebSocket.Talk.Config;

import WebSocket.Talk.Config.HandShake.AuthHandshakeInterceptor;
import WebSocket.Talk.Config.HandShake.UserHandShakeHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        config.setApplicationDestinationPrefixes("/app");// prefixo de entrada
        config.setUserDestinationPrefix("/user");
        config.enableSimpleBroker("/queue","/topic"); //canal de saida

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .addInterceptors(new AuthHandshakeInterceptor())
                .setHandshakeHandler(new UserHandShakeHandler())
                .setAllowedOriginPatterns("http://127.0.0.1:5500") // link de uso da api
                .withSockJS();
    }



}
