package gerenciador.despesas.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Tests")
public class test {
    @GetMapping("/getHelloWord")
    public String helloWord(){
        return "Hello word";
    }
}
