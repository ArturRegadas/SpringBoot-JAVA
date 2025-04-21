package WebSocket.Talk.Controller;

import WebSocket.Talk.Model.ChatMessageModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/send") // escuta em /app/send
    @SendTo("/topic/messages") // envia para /topic/messages
    public String handle(String message) {
        return "Servidor recebeu: " + message;
    }

}
