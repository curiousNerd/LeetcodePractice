package Array.Leetcode.Easy;

import java.util.Arrays;

public class Ex_8_MergeSortedArray_88 {

    public void merge_bruteForce(int[] nums1, int m, int[] nums2, int n) {

        /**
         * Algorithm:
         * In the parameters received in the function m and n corresponds to number of initialized
         * element in nums1 and nums2
         * So in the bigger array i.e. nums1 only m elements are initialized and there is space for
         * new elements.
         * The code iterates over the smaller array and directly add all the elements of the
         * smaller array to the back of bigger array
         * Sort the bigger array
         *
         * Output: Accepted
         *
         * Space Complexity -> O()
         * We are creating a new array for storing results
         *
         * Time Complexity -> O((n+m) log (m+n))
         * Space Complexity -> O(n) [can vary - most programming language use O(n)]
         *
         * */

        for(int i=0; i<n; i++) {
            nums1[i+m] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void merge_lineaer_3Pointer_end(int[] nums1, int m, int[] nums2, int n) {

        /**
         * Algorithm:
         * Here we are using three pointer approach - and we ae starting from the end.
         * So 2 read pointers are used, one for each array where they track the position of the respective array from the end
         * One write pointer is used which writes into the array from the end.
         *Therefore elements from the back are  compared against each other and the larger element is inserted at the back.
         *
         * Output: Accepted
         *
         * Space Complexity -> O(1)
         *
         * Time Complexity -> O(m+n)
         *
         * */

        int p1 = m-1;
        int p2 = n-1;
        int p = nums1.length -1;

        while(p > -1){

            int cand1 = p1 > -1 ? nums1[p1] : Integer.MIN_VALUE;
            int cand2 = p2 > -1 ? nums2[p2] : Integer.MIN_VALUE;

            if(cand1 > cand2){
                nums1[p] = cand1;
                p1 --;
            }else{
                nums2[p] = cand2;
                p2 --;
            }

            p --;
        }

    }
}
