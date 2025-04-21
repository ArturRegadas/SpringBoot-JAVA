package WebSocket.Talk.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Messages")
public class ChatMessageModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long senderId;

    @Column
    private Long recipientId;

    @Column
    private String content;

    @Column
    private String type;

    public Long getId(){
        return id;
    }
    public Long getSenderId() {
        return senderId;
    }
    public Long getRecipientId(){
        return recipientId;
    }
    public String getContent(){
        return content;
    }
    public String getType(){
        return type;
    }


    public void setId(Long id){
        this.id = id;
    }
    public void setSenderId(Long id){
        this.senderId = id;
    }
    public void setRecipientId(Long id){
        this.recipientId = id;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setType(String type){
        this.type = type;
    }
}
