package Leetcode.Array.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Ex_3_HighFive_1086 {

    public int[][] highFive_bruteForce(int[][] items) {

        //O(1) < O(logN) < O(N) < O(N logN) < O(N²) < O(2ᴺ) < O(N!)

        /**
         * Algo:
         * step1: Iterate over each row and create a Map with ID as Key and all the scores as value
         * step2: Iterate over keys in Map
         * step3: For each key sort the corresponding ArrayList of Scores in descending order
         * step4: Take top 5 elements from this Leetcode.Array and calculate Avg
         * step5: Add (Id, AvgScore) in the return array
         * step6: After Iteration completes - return this new array
         *
         *
         * Output: Accepted
         * Runtime - beats 85%
         * Memory - beats 99%
         *
         * Space Complexity -> >
         * Time Complexity -> O(N log N)
         *
         * Verdict : _
         * */

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int uniqueIds = 0;

        for(int x = 0; x< items.length; x++){

            int id = items[x][0];
            int score = items[x][1];

            if(map.containsKey(id)){
                ArrayList<Integer> value = map.get(id);
                value.add(score);
            }else{
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(score);
                map.put(id,arr);
                uniqueIds ++;

            }

        }

        int [][] avgArray = new int [uniqueIds][2];
        int row = 0;
        for(int id: map.keySet()){ //O(n/5) = O(n)
            ArrayList<Integer> arr = map.get(id);
            Collections.sort(arr, Collections.reverseOrder()); //O(N log N)
            int count = 1;
            int sum = 0;
            for(int item: arr){
                if(count <= 5){
                    sum = sum + item;
                    count ++;
                }
            }
            avgArray[row][0] = id;
            avgArray[row][1] = sum/5;
            row++;
        }

        return avgArray;
    }


}
