package gerenciador.despesas.Controller;

import gerenciador.despesas.Model.TransactionModel;
import gerenciador.despesas.Service.TransactionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private TransactionService transactionService;


    @GetMapping("/getTransactionsBySender")
    public List<TransactionModel> getTransactionsBySender(@RequestParam Long id){return transactionService.getTransactionBySender(id);}

    @GetMapping("/getTransactionBySenderGreaterThan")
    public List<TransactionModel> getTransactionBySenderGreaterThan(@RequestParam Long id, @RequestParam double value){
        return transactionService.getTransactionBySenderGreaterThan(id, value);
    }

    @GetMapping("/getTransactionBySenderAndRecipient")
    public List<TransactionModel> getTransactionBySenderAndRecipient(@RequestParam Long senderId, @RequestParam Long recipientId){
        return transactionService.getTransactionBySenderAndRecipient(senderId, recipientId);
    }




}
