package week.three;

/**
 * 
 * @author Celestino Agudo
 *	https://www.hackerrank.com/challenges/utopian-tree/problem
 *
 */
public class UtopianThree {
	
	public static void main(String[] args) {
		System.out.println(utopianTree(4));
	}
	
	public static int utopianTree(int n) {
		
		if(n == 0) {
			
			return 1; 
		}
		
		int growth = 1;
		
		for(int counter = 1; counter <= n; ++counter) {
			if(counter%2 == 0) {
				growth += 1;
			}
			else {
				growth *= 2;
			}
		}
		
		return growth;
	}

}
