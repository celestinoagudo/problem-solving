package week.three;

/**
 * 
 * @author Celestino Agudo
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
 *
 */

public class BeautifulDaysAtTheMovies {
	
	public static void main(String[] args) {
		System.out.println(beautifulDays(20,23,6));
		
	}
	
	public static int beautifulDays(int i, int j, int k) {
		
		int numberOfBeautifulDays = 0;
		for(int counter = i; counter <= j; ++counter) {
			
			String reversed = new StringBuilder(String.valueOf(counter))
									.reverse().toString();
			int reversedAsInt = Integer.parseInt(reversed);
			if(((counter - reversedAsInt) % k) == 0) {
				++numberOfBeautifulDays;
			}
			
		}
		return numberOfBeautifulDays;
	}

}
