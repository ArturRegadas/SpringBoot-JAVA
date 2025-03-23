package Itau.demo.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import Itau.demo.Utility.Transacao;


@RestController
public class TransacaoController {
    @PostMapping("/transacao")
    public ResponseEntity transacao(@RequestBody Transacao data){

        if(!data.isAccept())return ResponseEntity.status(422).build();
        ResponseEntity response = ResponseEntity.status(HttpStatus.CREATED).build();
        
        data.addToDataBase(String.valueOf(data.getValor()), data.getDataHora().toString());
        
        return response;
    }
    
}
