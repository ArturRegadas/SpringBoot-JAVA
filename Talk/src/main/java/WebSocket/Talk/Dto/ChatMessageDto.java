package WebSocket.Talk.Dto;

public class ChatMessageDto {
    private Long id;
    private Long senderId;
    private Long recipientId;
    private String content;
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
