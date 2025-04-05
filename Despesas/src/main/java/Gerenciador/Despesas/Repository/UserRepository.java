package gerenciador.despesas.Repository;

import gerenciador.despesas.Model.UserModel;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    @Modifying
    @Transactional
    @Query("UPDATE UserModel u SET u.balance = :newBalance WHERE u.id = :id")
    public void updateBalance(@Param("id") Long id, @Param("newBalance") double newBalance);

}