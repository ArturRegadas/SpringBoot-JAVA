package gerenciador.despesas.Model;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transactions")
public class TransactionModel {
    @Id
    @Column
    private Long id;

    @Column
    private Long senderId;

    @Column Long recipientId;

    @Column
    private Double value;

    @Column
    private OffsetDateTime dateTime;

    public Long getSenderId() {return senderId;}

    public Long getRecipientId() {return recipientId;}

    public double getValue(){return value;}
}
