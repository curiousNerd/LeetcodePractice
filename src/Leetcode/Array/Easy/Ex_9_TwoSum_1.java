package Leetcode.Array.Easy;

import java.util.HashMap;

public class Ex_9_TwoSum_1 {

    /**
     * Algorithm:
     * This implementation basically uses two nested for loops and checks if
     * any of the ith and jth element sums up to the target
     *
     * Output: Accepted
     *
     * Time Complexity -> O(n^2)
     * Space Complexity -> O(1)
     *
     * */

    public int[] twoSum_bruteForce(int[] nums, int target) {
        int [] arr = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if((nums[i] + nums[j]) == target){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }

    public int[] twoSum_optimized(int[] nums, int target){

        /**
         * Algorithm:
         * Step 1: maintains a map which has key -> target - current element, value -> index of current  elem
         * Step 2: checks if the current element is present in the map - If yes, then returns the index from the map, and current element
         *
         * Output: Accepted
         *
         * Time Complexity -> O(n)
         * Space Complexity -> O(n)
         *
         **/

        HashMap<Integer,Integer> map = new HashMap<>();
        int [] arr = new int[2];
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                arr[0] = map.get(nums[i]);
                arr[1] = i;
                break;
            }else{
                map.put(target - nums[i],i);
            }
        }
        return arr;
    }
}
