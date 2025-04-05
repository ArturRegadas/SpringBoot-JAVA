package gerenciador.despesas.Service;

import gerenciador.despesas.Model.TransactionModel;
import gerenciador.despesas.Model.UserModel;
import gerenciador.despesas.Repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private TransactionService transactionService;

    public Optional<UserModel> getUserById(Long id){return userRepository.findById(id);}

    public UserModel addUserToDB(UserModel userToAdd){return userRepository.save(userToAdd);}

    public ResponseEntity<TransactionModel> transferMoney(TransactionModel transactionData){
        Optional<UserModel> senderUserOpt = getUserById(transactionData.getSenderId());
        Optional<UserModel> recipientUserOpt = getUserById(transactionData.getRecipientId());

        if(senderUserOpt.isPresent() && recipientUserOpt.isPresent()){
            UserModel senderUser = senderUserOpt.get();
            UserModel recipientUser = recipientUserOpt.get();

            if(senderUser.getBalance()>=transactionData.getValue()){
                userRepository.updateBalance(
                        transactionData.getSenderId(),
                        senderUser.getBalance()-transactionData.getValue()
                );
                userRepository.updateBalance(
                        transactionData.getRecipientId(),
                        recipientUser.getBalance()+transactionData.getValue()
                );
                TransactionModel newTransaction = transactionService.addTransaction(transactionData);
                return ResponseEntity.status(HttpStatus.CREATED).body(newTransaction);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(transactionData);
        }
        return ResponseEntity.notFound().build();
    }

    public boolean deleteUserById(Long id){
        boolean ans = userRepository.existsById(id);
        userRepository.deleteById(id);
        return ans;
    }


}
