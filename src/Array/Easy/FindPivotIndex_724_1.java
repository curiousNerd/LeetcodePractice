package Array.Easy;

public class FindPivotIndex_724_1 {

    public int pivotIndex_bruteForce(int[] nums) {

        /**
         * This solution has a outer for loop to iterate over the array
         *         Inside for loop the code maintains 2 while loops
         *              one for tracking left sum and
         *              other for tracking right sum
         * The loop breaks only when the right and left sum are equal
         * Worst case - > It will iterate ove the entire list with each iteration having
         *                2 sub iterations to it.
         *
         * Output: Accepted
         * Runtime - beats 6%
         * Memory - beats 73%
         *
         * Big O ->
         *
         * Verdict : BruteForce implementation
         * */

        int index = -1;


        for(int i = 0; i < nums.length; i++){

            int xLeft = i-1;
            int xRight = i+1;
            int sumLeft = 0;
            int sumRight = 0;


            while(xRight < nums.length){
                sumRight = sumRight + nums[xRight];
                xRight += 1;
            }

            while(xLeft >= 0){
                sumLeft = sumLeft + nums[xLeft];
                xLeft -= 1;
            }

            if(sumLeft == sumRight){
                index = i;
                break;
            }

        }

        return index;
    }

    public int pivotIndex_optimized(int[] nums) {

        /**
         * This solution iterates over the array first and calculates the sum of the entire array
         * Iterate over the array again and
         *          subtracts current element from the sum and compares with the left sum
         *          if equal = break
         *          else adds current elsement to the left sum
         *
         * Output: Accepted
         * Runtime - beats 100%
         * Memory - beats 73%
         *
         * Big O ->
         *
         * Verdict : BestCase implementation
         * */

        int sum = 0;
        int index = -1;
        int leftSum = 0;

        for( int i = 0; i < nums.length; i ++){
            sum += nums[i];
        }

        for(int i =0; i < nums.length; i++){
            sum -= nums[i];

            if(leftSum == sum){
                index = i;
                break;
            }

            leftSum += nums[i];
        }

        return index;

    }
}
