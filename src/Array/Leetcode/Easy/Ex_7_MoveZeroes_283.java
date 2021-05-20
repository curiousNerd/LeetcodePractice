package Array.Leetcode.Easy;

public class Ex_7_MoveZeroes_283 {

    public void moveZeroes_self(int[] nums) {
        /**
         * Algorithm:
         * There is a count variable and an end variable which keeps track of
         * number of consecutive zeroes and the remaining arrays length after
         * moving one set of consecutive zeroes to the end.
         *
         * Outer loop - iterates over the elements from i=0 to end.
         * Nested while loop - this is to target all the consecutive zeroes - loop continues till
         * the current element remains zero and breaks only in the case where counter reaches the
         * length of the array [i.e. in case it is an all zero array]
         * Nested inner loop - responsible for moving the zeroes to the end.
         *
         * Output: Accepted
         *
         * Space Complexity -> O(1)
         * We are not creating any new copies of the array
         *
         * Time Complexity -> > O(n^2)
         * Confusing but most likely exponential complexity
         *
         *
         * */

        int count;
        int end = nums.length;
        int value;
        for(int i=0; i<end; i++){
            count = 0;
            while(nums[i] == 0){
                count ++;
                if(count == nums.length){
                    break;
                }
                value = nums[i];
                for(int j=i+1; j<nums.length; j++){
                    int temp = nums[j];
                    nums[j-1] = temp;
                    nums[j] = value;
                }

//                System.out.println("++"+count);
//                for(int x=0; x<nums.length; x++){
//                    System.out.print(nums[x]+" ");
//                }
                end --;

//                System.out.println();
            }
        }
    }

    public void moveZeroes_linear_creatingNewArray(int[] nums){

        /**
         * Algorithm:
         * It accounts for very simple logic where an intermediate array is used to store the result.
         *
         * The trick here is -> when a new array is created using new operator all the elements are
         * initialized to zero
         * Now the only part is to add non-zero values to this array in the starting.
         * Once Done, replace original array with the elements of this intermediate array
         *
         * Output: Accepted
         *
         * Space Complexity -> O(n)
         * We are creating a new array for storing results
         *
         * Time Complexity -> > O(n)
         *
         * */

        int index = 0;
        int [] arr = new int [nums.length] ;

        for(int i =0; i < nums.length; i++){
            if(nums[i] != 0){
                arr[index] = nums[i];
                index++;
            }
        }

        for(int i = 0; i<nums.length; i++){
            nums[i] = arr[i];
        }

    }

    public void moveZeroes_linear_inPlace(int[] nums) {

        /**
         * Algorithm:
         * It iterates over the array and if the element is non-zero then in the same order moves
         * it to the front of the array
         * Captures lastNonZero index and fills all elements past it with 0
         *
         * Output: Accepted
         *
         * Space Complexity -> O(1)
         * Time Complexity -> > O(n)
         *
         * */


        int lastNonZeroIndex = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        for(int i=lastNonZeroIndex; i<nums.length; i++){
            nums[i] = 0;
        }
    }


        public static void main(String [] args){
        Ex_7_MoveZeroes_283 obj = new Ex_7_MoveZeroes_283();
        int [] arr = {0,0,0,0,1,0,0,2};
        obj.moveZeroes_self(arr);

    }
}
