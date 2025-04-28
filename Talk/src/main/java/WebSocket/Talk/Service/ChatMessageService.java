package WebSocket.Talk.Service;

import WebSocket.Talk.Model.ChatMessageModel;
import WebSocket.Talk.Repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<ChatMessageModel> getConversationsBySenderAndRecipient(Long senderId, Long recipientId){
        return chatMessageRepository.findBySenderAndRecipient(senderId, recipientId);
    }
}
