package Itau.demo.DBManipulation;

import java.sql.*;
import java.util.*;
import Itau.demo.DBManipulation.DataBase;
import java.time.OffsetDateTime;
public class Testdb {
    public static void main(String[] args){
    	    
        String URL = "jdbc:postgresql://localhost:5432/itauusers";
        String USER = "postgres";
        String PASSWORD = "abc2109";
        
        DataBase db = new DataBase();
        db.addToDb("transacoes", "123.45", OffsetDateTime.now().toString());
        db.printDB("transacoes");
    }    
}