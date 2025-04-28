package WebSocket.Talk.Controller;

import WebSocket.Talk.Model.ChatMessageModel;
import WebSocket.Talk.Security.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
public class WSChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public WSChatController(SimpMessagingTemplate messagingTemplate){
        this.messagingTemplate=messagingTemplate;
    }

    @MessageMapping("/send") // escuta em /app/send
    @SendTo("/topic/messages") // envia para /topic/messages
    public ChatMessageModel sendMessage(ChatMessageModel message) {
        return message;
    }

    @MessageMapping("/chat.private") //destino para o envio de mensagens privadas
    public void sendPrivateMessage(ChatMessageModel chatMessage){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        Long loggedUserId = userDetails.getId();

        //remetente
        if(chatMessage.getSenderId().equals(loggedUserId)){
            messagingTemplate.convertAndSendToUser(
                    chatMessage.getRecipientId().toString(),
                    "queue/messages",
                    chatMessage
            );
        }
    }



}
