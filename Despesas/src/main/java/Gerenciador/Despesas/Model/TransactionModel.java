package gerenciador.despesas.Model;

import java.time.OffsetDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "Transactions")
public class TransactionModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long senderId;

    @Column
    private Long recipientId;

    @Column
    private Double value;

    @Column
    private OffsetDateTime dateTime;

    public Long getId(){return id;}
    public Long getSenderId() {return senderId;}
    public Long getRecipientId() {return recipientId;}
    public double getValue(){return value;}
    public OffsetDateTime getDateTime(){return dateTime;}

    public void setSenderId(Long senderId) {this.senderId = senderId;}
    public void setRecipientId(Long recipientId) {this.recipientId = recipientId;}
    public void setValue(Double value) {this.value = value;}
    public void setDateTime(OffsetDateTime dateTime) {this.dateTime = dateTime;}
}
