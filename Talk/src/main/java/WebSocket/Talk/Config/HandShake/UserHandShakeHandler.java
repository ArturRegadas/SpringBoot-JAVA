package WebSocket.Talk.Config.HandShake;

import WebSocket.Talk.Model.StompPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

public class UserHandShakeHandler extends DefaultHandshakeHandler {
    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
                                      Map<String, Object> attributes) {

        HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
        HttpSession session = servletRequest.getSession(false);

        if (session != null) {
            Object userId = session.getAttribute("userId");
            if (userId != null) {
                System.out.println("Handshake atribuiu userId: " + userId);
                return () -> userId.toString(); // <<<< isso é crucial
            }
        }
        return null;
    }
}

