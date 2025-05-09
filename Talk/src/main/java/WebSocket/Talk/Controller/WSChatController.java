package WebSocket.Talk.Controller;

import WebSocket.Talk.Model.ChatMessageModel;
import WebSocket.Talk.Security.MyUserDetails;
import WebSocket.Talk.Service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WSChatController {

    @Autowired
    private ChatMessageService chatMessageService;

    private final SimpMessagingTemplate messagingTemplate;

    public WSChatController(SimpMessagingTemplate messagingTemplate){
        this.messagingTemplate=messagingTemplate;
    }

    @MessageMapping("/send") // escuta em /app/send
    @SendTo("/topic/messages") // envia para /topic/messages
    public ChatMessageModel sendMessage(ChatMessageModel message) {
        return message;
    }

    @MessageMapping("/chat.private")
    public void sendPrivateMessage(Principal principal, ChatMessageModel chatMessage) {
        Long loggedUserId = Long.parseLong(principal.getName());

        if (chatMessage.getSenderId().equals(loggedUserId)) {
            messagingTemplate.convertAndSendToUser(
                    chatMessage.getRecipientId().toString(),
                    "/queue/messages",
                    chatMessage
            );
            chatMessage.setType("MSG");
            chatMessageService.addMessage(chatMessage);// to DB
        }
    }




}
