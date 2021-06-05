package week.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Celestino Agudo
 * @see https://www.hackerrank.com/challenges/sock-merchant/problem
 *
 */
public class SalesByMatch {
	
	public static void main(String[] args) {
		List<Integer> inputs = new ArrayList<Integer>();
		inputs.add(10);
		inputs.add(20);
		inputs.add(20);
		inputs.add(10);
		inputs.add(10);
		inputs.add(30);
		inputs.add(50);
		inputs.add(10);
		inputs.add(20);
		
		
		
		
		System.out.println(sockMerchant(inputs.size(), inputs));
	}
	
    public static int sockMerchant(int n, List<Integer> ar) {
    	
    	Map<Integer, Integer> inputs = new HashMap<>();
    	for(Integer input : ar) {
    		if(!inputs.containsKey(input)) {
    			inputs.put(input, 1);
    		}
    		else {
    			inputs.put(input, inputs.get(input) + 1);
    		}
    	}
    	
    	int totalNumberOfPairs = 0;
    	
    	for(Map.Entry<Integer, Integer> entry : inputs.entrySet()) {
    		Integer value = entry.getValue();
    		
    		totalNumberOfPairs += (value / 2);
    	}
    	
    	return totalNumberOfPairs;

    }


}
