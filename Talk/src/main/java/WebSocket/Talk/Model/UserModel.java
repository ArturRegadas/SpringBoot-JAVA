package WebSocket.Talk.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String password;

    public Long getId() {
        return id;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }


    public void setId(Long id){
        this.id = id;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassword(String password){
        this.password = password;
    }

}
