package Privacy.Security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/tests")
public class Tests {
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/adm/getHelloWorld")
    public String getHelloWorld(){
        return "Hello World";
    }
}
