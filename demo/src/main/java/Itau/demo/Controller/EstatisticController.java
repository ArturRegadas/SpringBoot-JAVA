package Itau.demo.Controller;

import java.util.*;
import Itau.demo.Utility.Pair;
import Itau.demo.Utility.EstatisticDB;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstatisticController {
	@GetMapping("/estastistica")
	public Map<String, Double> estastistica(){
		EstatisticDB getEstatistic = new EstatisticDB();
		Map<String, Double> result  = new HashMap<>();
		double cont = getEstatistic.getCount();
		result.put("count", cont);
		
		double sum = getEstatistic.getSum();
		result.put("sum", sum);
		
		double avg = getEstatistic.getMed();
		result.put("avg", avg);
		
		double min = getEstatistic.getMin();
		result.put("min", min);
		
		double max = getEstatistic.getMax();
		result.put("max", max);
		
		
		return result;
	}
}
