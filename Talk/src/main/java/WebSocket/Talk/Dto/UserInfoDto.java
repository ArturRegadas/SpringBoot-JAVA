package WebSocket.Talk.Dto;

public class UserInfoDto {
    private Long id;
    private String userName;

    public UserInfoDto(Long id, String userName){
        this.id=id;
        this.userName=userName;
    }

    public Long getId(){
        return id;
    }

    public String getUserName(){
        return userName;
    }

    public void setId(Long id){
        this.id=id;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
}
