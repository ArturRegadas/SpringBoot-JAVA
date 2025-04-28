package WebSocket.Talk.Controller;

import WebSocket.Talk.Model.ChatMessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {
    //@Autowired
    //private

    @GetMapping("/getConversation/{userId}")
    public ResponseEntity<ChatMessageModel> getConversation(@PathVariable Long userId){
        return ResponseEntity.ok().build();
    }
}
