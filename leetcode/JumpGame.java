package leet.code.practice.set;

public class JumpGame {

  /**
   * You are given an integer array nums. You are initially positioned at the array's first index,
   * and each element in the array represents your maximum jump length at that position. Return true
   * if you can reach the last index, or false otherwise.
   * 
   * @param nums integer array
   * @return flag which determines if we can reach the last element
   */
  public static boolean canJump(int[] nums) {
    if (nums.length == 1) {
      return true;
    }
    int initialJumpsAllowed = nums[0];
    if (initialJumpsAllowed == 0) {
      return false;
    }
    if ((initialJumpsAllowed > nums.length) || (initialJumpsAllowed == (nums.length - 1))) {
      return true;
    }
    int maximumReachable = 0;
    for (int index = 0; index < nums.length; ++index) {
      final int currentMaximumReachable = index + nums[index];
      if (currentMaximumReachable > maximumReachable) {
        maximumReachable = currentMaximumReachable;
        if (maximumReachable >= (nums.length - 1)) {
          return true;
        }
      }
      if (maximumReachable == index) {
        return false;
      }
    }
    return maximumReachable >= (nums.length - 1);
  }

  public static void main(String[] args) {
    System.out.println(canJump(new int[] {1}));
    System.out.println(canJump(new int[] {2, 0}));
    System.out.println(canJump(new int[] {2, 3, 1, 1, 4}));
    System.out.println(canJump(new int[] {3, 2, 1, 0, 4}));
    System.out.println(canJump(new int[] {1, 0, 1, 0}));
    System.out.println(canJump(new int[] {0}));
    System.out.println(canJump(new int[] {2, 0, 0}));
    System.out.println(canJump(new int[] {2, 5, 0, 0}));
    System.out.println(canJump(new int[] {1, 1, 1, 0}));
  }

}
