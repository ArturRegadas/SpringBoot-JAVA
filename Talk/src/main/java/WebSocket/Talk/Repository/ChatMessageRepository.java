package WebSocket.Talk.Repository;

import WebSocket.Talk.Model.ChatMessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageModel, Long> {
}
