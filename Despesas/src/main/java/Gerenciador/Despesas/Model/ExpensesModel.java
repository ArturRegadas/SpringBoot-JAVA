package gerenciador.despesas.Model;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Expenses")
public class ExpensesModel {
    @Id
    @Column
    private Long id;

    @Column
    private Long userId;

    @Column
    private OffsetDateTime dateTime;

    @Column
    private Double value;
}
