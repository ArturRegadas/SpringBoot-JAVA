package Itau.demo.DBManipulation;

import java.util.*;
import java.sql.*;
import Itau.demo.Utility.Transacao;

public class DataBase {
    private Connection connect;
    private String URL = "jdbc:postgresql://localhost:5432/itauusers";
    private String USER = "postgres";
    private String PASSWORD = "abc2109";

    public DataBase() {
        try{this.connect = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
            System.out.println("Connect with sucess");
            
        }
        catch(Exception e){
            System.err.println("Error with connect: "+e);
            
        }
    }
   
    public Vector<Vector<String>> printDB(String nameTable){
        String SSQL = "SELECT * FROM "+ nameTable+";";
        try(PreparedStatement preparedStatement = connect.prepareStatement(SSQL);
        ResultSet response = preparedStatement.executeQuery()){
            System.out.println("OK-printDB");
            Vector<Vector<String>> transacoes = new Vector<>();
            
            while (response.next()) {
            	Vector<String> AUX = new Vector<>();
            	AUX.add(response.getString("valor"));
            	AUX.add(response.getString("dataHora"));
            	transacoes.add(AUX);
            }
            return transacoes;
        }
        catch(Exception e){
            System.err.println("fail-printDB");
            return new Vector<>();
        }
        
    }


    
    public void addToDb(String nameTable,String value1, String value2){
        String SSQL = "INSERT INTO "+nameTable+" (valor, dataHora) VALUES ("+value1+", '"+value2+"');";
        try(PreparedStatement preparedStatement = connect.prepareStatement(SSQL);){
        	preparedStatement.executeUpdate();
            System.out.println("ok-addToDb");
        }
        catch(Exception e){
            System.err.println("fail-addToDb");
        }
    }
   

    
}
