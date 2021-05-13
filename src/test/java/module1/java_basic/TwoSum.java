package module1.java_basic;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main (String [] args) throws InterruptedException {
        int[] nums = {2, 3, 11, 15};
        int target = 9;
    // int [] resultado = twoSum(nums,target);
       //System.out.println("Two suma es "+ resultado[0] +resultado[1]);

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

  /*  public int[] twoSumTwo(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap <> ();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }*/
}
