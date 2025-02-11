package Itau.demo.controler;



import org.springframework.web.bind.annotation.*;



@RestController
public class Test {

    @GetMapping("/test")
    public String test(){
        return "Ok";
    }
    
}

