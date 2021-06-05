package week.one;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Celestino Agudo
 *
 */
public class BetweenTwoSets {
	
	public static void main(String[] args) {
		
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(6);
		List<Integer> b = new ArrayList<Integer>();
		b.add(24);
		b.add(36);
		
		int numbersBetween = 0;
		
		outer:
		for(int min = 1; min <= 100; ++min) {
			for(int number : a) {
				if(!((min % number ) == 0)) {
					continue outer;
				}
			}
			for(int number : b) {
				if(!((number % min ) == 0)) {
					continue outer;
				}
			}
			System.out.println(min);
			++numbersBetween;
			
		}
		
		System.out.println(numbersBetween);
		
	}

}
