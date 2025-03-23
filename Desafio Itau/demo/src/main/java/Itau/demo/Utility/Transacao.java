package Itau.demo.Utility;
import java.time.OffsetDateTime; //uso do modelo ISO 8601
//"2020-08-07T12:34:56.789-03:00"
//import java.time.ZoneOffset;fuso horario
import Itau.demo.DBManipulation.DataBase;
import java.util.*;

public class Transacao{
    private Double valor;
    private OffsetDateTime dataHora;
    private DataBase db = new DataBase();
    private static final String TABLE = "transacoes";
    
    
    public Double getValor() { return valor; }
    public OffsetDateTime getDataHora() { return dataHora; }

    public boolean isAccept(){
        OffsetDateTime today = OffsetDateTime.now();
        if(valor == null || dataHora == null || !dataHora.isBefore(today) || valor < 0)return false;
        return true;
    }
    public void addToDataBase(String v1, String v2){
         db.addToDb(TABLE,v1,v2);
    }


}