package gerenciador.despesas.Repository;

import gerenciador.despesas.Model.ExpensesModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<ExpensesModel,Long>{}
