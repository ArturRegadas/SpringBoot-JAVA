package WebSocket.Talk.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class Tests {
    @GetMapping("/getHelloWorld")
    public String getHelloWorld(){
        return "Hello World";
    }
}
