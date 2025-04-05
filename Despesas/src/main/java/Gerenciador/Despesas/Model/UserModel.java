package gerenciador.despesas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class UserModel {
    @Id
    @Column
    private Long id;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private double balance;

    public double getBalance(){return balance;}

}
