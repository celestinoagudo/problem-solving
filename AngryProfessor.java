package week.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Celestino Agudo
 * https://www.hackerrank.com/challenges/angry-professor/problem?h_r=next-challenge&h_v=zen
 */

public class AngryProfessor {
	
	public static void main(String[] args) {
		
		List<Integer> a = new ArrayList<>();
		a.add(-1); a.add(-3); a.add(4); a.add(2);
		System.out.println(angryProfessor(3, a));
	}
	
	public static String angryProfessor(int k, List<Integer> a) {
		
		int numberOfStudentsArrivedOnTime = 0;
		
		for(int arrivalTime : a) {
			if(arrivalTime <= 0) {
				++numberOfStudentsArrivedOnTime;
			}
		}
		
		return numberOfStudentsArrivedOnTime >= k ? "NO" : "YES";
	}

}
