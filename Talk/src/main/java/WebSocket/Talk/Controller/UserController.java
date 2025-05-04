package WebSocket.Talk.Controller;

import WebSocket.Talk.Dto.LoginInfoDto;
import WebSocket.Talk.Dto.UserInfoDto;
import WebSocket.Talk.Model.UserModel;
import WebSocket.Talk.Service.UserService;

import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/createUser")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userForAdd){
        UserModel newUser = userService.createUser(userForAdd);
        //vericar se username já existe
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/login")
    public ResponseEntity<UserModel> loginUser(@RequestBody LoginInfoDto loginInfo, HttpSession session) {
        UserModel user = userService.loginUser(loginInfo.getUserName(), loginInfo.getPassword());
        if (user == null)
            return ResponseEntity.notFound().build();

        // Verificação do usuário
        if (user.getPassword().equals(loginInfo.getPassword())) {
            session.setAttribute("userId", user.getId());  // Salva o userId na sessão
            return ResponseEntity.ok().body(user);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
    }




    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserInfoDto>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
}
