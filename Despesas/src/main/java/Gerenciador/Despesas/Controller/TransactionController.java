package gerenciador.despesas.Controller;

import gerenciador.despesas.Model.TransactionModel;
import gerenciador.despesas.Model.UserModel;
import gerenciador.despesas.Service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @GetMapping("/getTransactionsBySender")
    public List<TransactionModel> getTransactionsBySender(@RequestParam Long id){return transactionService.getTransactionsBySender(id);}

    @GetMapping("/getTransactionsBySenderGreaterThan")
    public List<TransactionModel> getTransactionsBySenderGreaterThan(@RequestParam Long id, @RequestParam double value){
        return transactionService.getTransactionsBySenderGreaterThan(id, value);
    }

    @GetMapping("/getTransactionsBySenderAndRecipient")
    public List<TransactionModel> getTransactionsBySenderAndRecipient(@RequestParam Long senderId, @RequestParam Long recipientId){
        return transactionService.getTransactionsBySenderAndRecipient(senderId, recipientId);
    }

}
