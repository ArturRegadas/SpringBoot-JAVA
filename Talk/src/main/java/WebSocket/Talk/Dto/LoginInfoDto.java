package WebSocket.Talk.Dto;

public class LoginInfoDto {
    private String userName;
    private String password;

    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

    public void setPassword(String password){
        this.password=password;
    }

}
