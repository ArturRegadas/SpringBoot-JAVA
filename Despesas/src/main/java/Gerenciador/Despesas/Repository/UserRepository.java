package gerenciador.despesas.Repository;

import gerenciador.despesas.Model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{}