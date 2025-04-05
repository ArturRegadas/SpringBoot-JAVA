package gerenciador.despesas.Service;

import gerenciador.despesas.Model.TransactionModel;
import gerenciador.despesas.Repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionModel> getTransactionsBySender(Long id){return transactionRepository.findBySenderId(id);}

    public List<TransactionModel> getTransactionsBySenderGreaterThan(Long id, double value){
        return transactionRepository.findBySenderIdAndValueGreaterThan(id, value);
    }

    public List<TransactionModel> getTransactionsBySenderAndRecipient(Long senderId, Long recipientId){
        return transactionRepository.findBySenderIdAndRecipientId(senderId, recipientId);
    }

    public TransactionModel addTransaction(TransactionModel transactionToAdd){
        TransactionModel newTransaction = transactionRepository.save(transactionToAdd);
        transactionRepository.flush();
        return newTransaction;

    }

}