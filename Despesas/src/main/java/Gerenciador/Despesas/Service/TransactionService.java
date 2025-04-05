package gerenciador.despesas.Service;

import gerenciador.despesas.Model.TransactionModel;
import gerenciador.despesas.Repository.TransactionRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    public List<TransactionModel> getTransactionBySender(Long id){return transactionRepository.findBySenderId(id);}

    public List<TransactionModel> getTransactionBySenderGreaterThan(Long id, double value){
        return transactionRepository.findBySenderIdAndValueGreaterThan(id, value);
    }

    public List<TransactionModel> getTransactionBySenderAndRecipient(Long senderId, Long recipientId){
        return transactionRepository.findBySenderIdAndRecipientId(senderId, recipientId);
    }

    public TransactionModel addTransaction(TransactionModel transactionToAdd){
        return transactionRepository.save(transactionToAdd);
    }

}