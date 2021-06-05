package week.two;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Celestino Agudo
 * @see https://www.hackerrank.com/challenges/picking-numbers/problem
 */

public class PickingNumbers {
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(2);
		a.add(4);
		a.add(4);
		a.add(5);
		a.add(5);
		a.add(5);
		
		System.out.println(pickingNumbers(a));
	}
	
    public static int pickingNumbers(List<Integer> a) {
    	
    	int[] frequencies = new int[101];
    	for(int counter = 0; counter < a.size(); ++counter) {
    		frequencies[a.get(counter)]++;
    	}
    	int result = 0;
    	for(int counter = 1; counter < 101; ++counter) {
    		result = Math.max(result, frequencies[counter] + frequencies[counter - 1]);
    	}
    
    	return result;

    }
    
}
