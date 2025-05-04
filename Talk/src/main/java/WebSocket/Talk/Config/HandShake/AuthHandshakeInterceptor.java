package WebSocket.Talk.Config.HandShake;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

public class AuthHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        if (request instanceof ServletServerHttpRequest servletRequest) {
            HttpSession session = servletRequest.getServletRequest().getSession(false);  // Recupera a sessão
            //System.out.println("userId encontrado: " + userId);

            System.out.println("Sessão ID: " + session.getId());
            if (session != null) {
                Object userId = session.getAttribute("userId");  // Recupera o userId da sessão

                var attributeNames = session.getAttributeNames();
                while (attributeNames.hasMoreElements()) {
                    String name = attributeNames.nextElement();
                    Object value = session.getAttribute(name);
                    System.out.println(" - " + name + ": " + value);
                }

                System.out.println("Atributos da sessão: " + session.getAttributeNames());
                if (userId != null) {
                    attributes.put("userId", userId);  // Coloca o userId nos atributos da conexão
                }
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Exception exception) {
    }
}
