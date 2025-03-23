package Itau.demo.Utility;
import Itau.demo.DBManipulation.DataBase;
import java.util.*;
import java.time.OffsetDateTime;
import java.time.Duration;

public class EstatisticDB {
    private static final String TABLE = "transacoes";
    private DataBase db;

    public EstatisticDB() {
        this.db = new DataBase();
    }
    
    public double getCount() {
    	Vector<Vector<String>> transacoes = db.printDB(TABLE);

        
        double result = 0;
        for(Vector<String> current : transacoes) {
            String dataHoraStr = current.get(1).replace(" ", "T");
            OffsetDateTime dataHora = OffsetDateTime.parse(dataHoraStr);
            OffsetDateTime now = OffsetDateTime.now();
            Duration diference = Duration.between(dataHora, now);
          
            if (diference.getSeconds() <= 60)
                result ++;
        }

        return result;
    }

    public double getSum() {
        Vector<Vector<String>> transacoes = db.printDB(TABLE);

        
        double result = 0;
        for(Vector<String> current : transacoes) {
            String dataHoraStr = current.get(1).replace(" ", "T");
            OffsetDateTime dataHora = OffsetDateTime.parse(dataHoraStr);
            OffsetDateTime now = OffsetDateTime.now();
            Duration diference = Duration.between(dataHora, now);
            
            
            if (diference.getSeconds() <= 60)
                result += Double.parseDouble(current.get(0));
        }

        return result;
    }
    
    public double getMed(){
    	return this.getSum()/this.getCount();
    }
    
    public double getMin() {
    	Vector<Vector<String>> transacoes = db.printDB(TABLE);
        
        double result = -1;
        for(Vector<String> current : transacoes) {
            String dataHoraStr = current.get(1).replace(" ", "T");
            OffsetDateTime dataHora = OffsetDateTime.parse(dataHoraStr);
            OffsetDateTime now = OffsetDateTime.now();
            Duration diference = Duration.between(dataHora, now);
            
            
            if (diference.getSeconds() <= 60)
                if(result == -1 || result > Double.parseDouble(current.get(0)))result = Double.parseDouble(current.get(0));
        }

        return result;
    }
    public double getMax() {
    	Vector<Vector<String>> transacoes = db.printDB(TABLE);
        
        double result = 0;
        for(Vector<String> current : transacoes) {
            String dataHoraStr = current.get(1).replace(" ", "T");
            OffsetDateTime dataHora = OffsetDateTime.parse(dataHoraStr);
            OffsetDateTime now = OffsetDateTime.now();
            Duration diference = Duration.between(dataHora, now);
            
            
            if (diference.getSeconds() <= 60)
                if( result < Double.parseDouble(current.get(0)))result = Double.parseDouble(current.get(0));
        }

        return result;
    }
}
