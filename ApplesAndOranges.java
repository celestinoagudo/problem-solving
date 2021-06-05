package week.one;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Celestino Agudo
 *
 */
public class ApplesAndOranges {

	public static void main(String[] args) {
		
		int s = 7;
		int t = 10;
		int a= 4;
		int b=12;
		
		List<Integer> apples = new ArrayList<Integer>();
		apples.add(2);
		apples.add(3);
		apples.add(-4);
		
		List<Integer> oranges = new ArrayList<Integer>();
		oranges.add(3);
		oranges.add(-2);
		oranges.add(-4);
		
		List<Integer> distanceFromA = new ArrayList<Integer>();
		List<Integer> distanceFromB = new ArrayList<Integer>();
		
		int numberOfApplesThatFallOnSamsHouse = 0;
		int numberOfOrangesThatFallOnSamsHouse = 0;
		
		apples.forEach(apple -> {
			distanceFromA.add(a + apple);
		});
		
		oranges.forEach(orange -> {
			distanceFromB.add(b + orange);
		});
		
		for(Integer distance: distanceFromA) {
			if(distance >= s && distance <= t) {
				++numberOfApplesThatFallOnSamsHouse;
			}
		}
		
		for(Integer distance: distanceFromB) {
			if(distance >= s && distance <= t) {
				++numberOfOrangesThatFallOnSamsHouse;
			}
		}
		System.out.println(numberOfApplesThatFallOnSamsHouse);
		System.out.println(numberOfOrangesThatFallOnSamsHouse);
	}

}
