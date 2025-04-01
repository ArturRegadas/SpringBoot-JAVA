package gerenciador.despesas.Controller;

import gerenciador.despesas.Model.UserModel;
import gerenciador.despesas.Service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userToAdd){
        UserModel newUser = userService.addUserToDB(userToAdd);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
