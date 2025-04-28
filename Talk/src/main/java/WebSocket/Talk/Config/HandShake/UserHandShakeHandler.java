package WebSocket.Talk.Config.HandShake;

import WebSocket.Talk.Model.StompPrincipal;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

public class UserHandShakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request,
                                      WebSocketHandler wsHandler,
                                      Map<String, Object> attributes){
        Long userId = (Long) attributes.get("userId");
        if(userId != null){
            return new StompPrincipal(userId.toString());
        }
        return null;
    }
}
