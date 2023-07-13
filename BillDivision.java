package week.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Celestino Agudo
 * @see https://www.hackerrank.com/challenges/bon-appetit/problem
 * 
 */
public class BillDivision {


  public static void bonAppetit(List<Integer> bill, int k, int b) {
    Integer sum = 0;
    for (Integer item : bill) {
      sum += item;
    }
    sum -= bill.get(k);
    int actual = sum / 2;
    int charged = b - actual;
    if (charged > 0) {
      System.out.println(charged);
    } else {
      System.out.println("Bon Appetit");
    }

  }

  public static void main(String[] args) {
    List<Integer> bill = new ArrayList<Integer>();
    bill.add(3);
    bill.add(10);
    bill.add(2);
    bill.add(9);
    bonAppetit(bill, 1, 7);
  }
}
