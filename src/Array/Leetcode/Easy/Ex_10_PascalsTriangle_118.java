package Array.Leetcode.Easy;

import javafx.beans.binding.IntegerBinding;

import java.util.ArrayList;
import java.util.List;

public class Ex_10_PascalsTriangle_118 {

    /**
     * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
     *      1       [1]
     *     1 1      [1,1]
     *    1 2 1     [1,1+1,1]
     *   1 3 3 1    [1,1+2,1+2,1]
     *  1 4 6 4 1   [1,1+3,3+3,3+1,1]
     *
     *  n = 5
     *
     * */

    public List<List<Integer>> generate(int numRows) {

        /**
         * Algorithm:
         * Step 1: Outer for loop till numRows -> this will act as levels of the triangle
         * Step 2: Inner loop from 0 to i; -> this accounts for number of elements in each level
         * Step 3: Adding logic for all 1's: whenever j = 0 or j=i, element in the level is 1
         * Step 4: Rest of the cases: Get the elements of previous Level i.e i-1
         * Step 5: Get 2 numbers from the previous level that are directly above current element i.e. j & j-1
         * Step 6: Add the sum of these two as an element in the current level
         * Step 7: Add this new level to the result before the value of i changes
         *
         * Output: Accepted
         *
         * Time Complexity -> O(n^2)
         * Space Complexity -> O(n^2)
         *
         **/

        List<List<Integer>> result = new ArrayList<>();

        if(numRows==0){
            return result;
        }

        for(int i=0; i<numRows; i++){
            List<Integer> level = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    level.add(1);
                }else{
                    List<Integer>  prevLevel = result.get(i-1);
                    level.add(prevLevel.get(j-1)+prevLevel.get(j));
                }

            }
            result.add(level);
        }

        return result;

    }
}
