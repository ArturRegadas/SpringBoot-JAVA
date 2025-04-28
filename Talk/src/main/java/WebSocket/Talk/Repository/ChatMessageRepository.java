package WebSocket.Talk.Repository;

import WebSocket.Talk.Model.ChatMessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageModel, Long> {

    @Query("SELECT u FROM ChatMessageModel u " +
            "WHERE u.senderId = :senderId " +
            "AND u.recipientId = :recipientId")
    List<ChatMessageModel> findBySenderAndRecipient(@Param("senderId")Long senderId,
                                                    @Param("recipientId")Long recipientId);

}
