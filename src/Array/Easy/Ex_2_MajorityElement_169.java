package Array.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class Ex_2_MajorityElement_169 {

    /**
     * This is a bruteForce Solution, in which we iterate over the array twice (nested for loops)
     * where we count occurrence of each number, and as soon as it is grater than majority
     * we return it.
     *
     *
     * Output: Accepted
     *
     * Space Complexity -> O(1)

     * Time Complexity -> O(n^2)
     *
     * Verdict : HashMap implementation
     * */


    public int majorityElement_BruteForce(int[] nums){
        int majCount = nums.length/2;
        for(int i: nums){
            int count = 0;
            for(int j: nums){
                if(i == j){
                    count++;
                }
            }
            if(count > majCount){
                return  i;
            }
        }
        return -1;
    }

    public int majorityElement_Hashmap(int[] nums) {

        /**
         * This solution iterates on the elements of the array and keeps the track of count in the
         * Hashmap of the elements
         * While adding elements to the hashmap it maintains the element with the largest count
         * There is one Edge case which is handled separately -
         *              If the size of the array is one - the element is returned directly
         *
         *
         * Output: Accepted
         * Runtime - beats 29.27%
         * Memory - beats 39.93%
         *
         * Space Complexity -> O(n)
         * At most, the HashMap can contain n - (n/2) associations,
         * so it occupies O(n) space.
         * This is because an arbitrary array of length n can contain n distinct values,
         * but nums is guaranteed to contain a majority element,
         * which will occupy (at minimum) (n/2) + 1 array indices.
         * Therefore, n - (n/2) indices can be occupied by distinct,
         * non-majority elements (plus 1 for the majority element itself),
         * leaving us with (at most) n - (n/2) distinct elements.
         *
         * Time Complexity -> O(n)
         * We iterate over nums once and make a constant time HashMap insertion on each iteration.
         * Therefore, the algorithm runs in O(n)O(n) time.
         *
         *
         * Verdict : HashMap implementation
         * */

        if(nums.length == 1 ){
            return nums[0];
        }

        int max = 0;
        int maxElem = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                count += 1;
                map.put(nums[i],count);

                if(count > max){
                    max = count;
                    maxElem = nums[i];
                }
            }else{
                map.put(nums[i],1);
            }
        }

        if(max > nums.length/2){
            return maxElem;
        }else{
            return -1;
        }

    }

    public int majorityElement_highRated(int[] nums) {

        /**
         * /As the majority element is more than half of the array elements,
         * it will definitely be at the center of the array
         *
         * This works everytime as long as there is a majority element in the array
         *
         * Output: Accepted
         * Runtime - beats 99.93%
         * Memory - beats 73.29%
         *
         * Space Complexity -> > O(1)
         * Time Complexity -> O(n log n)
         *
         * Verdict : _
         * */

        Arrays.sort(nums);
        return nums[nums.length/2];

    }


}
