package gerenciador.despesas.Controller;

import gerenciador.despesas.Model.TransactionModel;
import gerenciador.despesas.Model.UserModel;
import gerenciador.despesas.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserData")
    public ResponseEntity<UserModel> getUserData(@RequestParam Long id){
        Optional<UserModel> userToGet = userService.getUserById(id);
        if(userToGet.isPresent())return ResponseEntity.ok(userToGet.get());
        return ResponseEntity.notFound().build()    ;
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userToAdd){
        UserModel newUser = userService.addUserToDB(userToAdd);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/transferMoney")
    public ResponseEntity<TransactionModel> transferMoney(@RequestBody TransactionModel transactionData){
        transactionData.setDateTime(OffsetDateTime.now());
        return userService.transferMoney(transactionData);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<UserModel> deleteUser(@RequestParam Long id){
        if(userService.deleteUserById(id))return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }




}
