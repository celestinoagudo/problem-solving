package week.one;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Celestino Agudo
 *
 */
public class SubarrayDivision {
	
	public static void main(String[] args) {
		
		int d = 4;
		int m = 1;
		
		List<Integer> s = new ArrayList<Integer>();
		s.add(4);

		
		List<Integer> subList = new ArrayList<Integer>();
		int totalNumberOfDivisions = 0;
		
		for(int counter = 0; counter < s.size(); ++counter) {
			if(counter + m > s.size()) {
				break;
			}
			subList = s.subList(counter, counter + m);
			
			int total = 0;
			for(Integer element : subList) {
				total += element;
			}
			if(total == d) {
				++totalNumberOfDivisions;
			}
			
		}
		System.out.println(totalNumberOfDivisions);
		
	}

}
