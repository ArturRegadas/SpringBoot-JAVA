package gerenciador.despesas.Repository;

import gerenciador.despesas.Model.TransactionModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel,Long>{

    @Query("SELECT t FROM TransactionModel t WHERE t.senderId = :senderId")
    public List<TransactionModel> findBySenderId(@Param("senderId") long senderId);

    @Query("SELECT t FROM TransactionModel t WHERE t.senderId = :senderId AND t.value > :value")
    public List<TransactionModel> findBySenderIdAndValueGreaterThan(@Param("senderId") Long senderId, @Param("value") double value);

    @Query("SELECT t FROM TransactionModel t WHERE t.senderId = :senderId AND t.recipientId = :recipientId")
    public List<TransactionModel> findBySenderIdAndRecipientId (@Param("senderId") Long senderId, @Param("recipientId") Long recipientId);

}
