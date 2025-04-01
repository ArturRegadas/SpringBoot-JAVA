package gerenciador.despesas.Service;

import gerenciador.despesas.Repository.ExpensesRepository;
import gerenciador.despesas.Model.ExpensesModel;

import org.springframework.stereotype.Service;

@Service
public class ExpensesService {

    private ExpensesRepository expenseRepository;

    public ExpensesModel addExpenseToDB(ExpensesModel expenseToAdd){return expenseRepository.save(expenseToAdd);}

}
