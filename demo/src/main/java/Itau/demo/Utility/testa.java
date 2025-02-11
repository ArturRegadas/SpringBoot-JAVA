package Itau.demo.Utility;
import Itau.demo.Utility.*;
import java.util.*;
public class testa {
	public static void main(String[] args) {
		EstatisticDB getEstatistic = new EstatisticDB();
		Map<String, Double> result  = new HashMap<>();
		double cont = getEstatistic.getCount();
		result.put("count", cont);
		
		System.out.println(result);
		}
}
