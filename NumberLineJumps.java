package week.one;
/**
 * 
 * @author Celestino Agudo
 *
 */
public class NumberLineJumps {
	
	public static void main(String[] args) {
		int x1 = 0;
		int v1 = 2;
		int x2 = 5;
		int v2 = 3;
		
		int k1CurrentLocation = x1;
		int k2CurrentLocation = x2;
		
		for(int jump = 1; jump <= 10000; ++jump) {
			k1CurrentLocation = k1CurrentLocation + v1;
			k2CurrentLocation = k2CurrentLocation + v2;
			if(k1CurrentLocation == k2CurrentLocation) {
				System.out.println("YES");
				return;
			}
		}
		if(k1CurrentLocation == k2CurrentLocation) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

}
