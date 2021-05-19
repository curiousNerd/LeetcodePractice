package Array.Leetcode.Easy;

public class Ex_4_BestTimeToBuyAndSellStocks_121 {

    public int maxProfit_bruteForce(int[] prices) {
        /**
         * Algo:
         * Step1: 2 nested forloops to check for maximum difference
         *
         *
         * Output: Time Limit Exceeded
         * Runtime - _
         * Memory - _
         *
         * Space Complexity -> > O(n)
         * Time Complexity -> O(n^2)
         *
         * Verdict : _
         * */
        int max = 0;
        for(int i=0; i< prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                int diff = prices[j] - prices[i];
                if(diff > max){
                    max = diff;
                    }
                }
        }
        return max;
    }

    public int maxProfit_optimized(int[] prices) {
        /**
         * Algo:
         * Step1: Initialize maxProfit and min
         * Step2: Iterate over the array
         * Step3: check and find new minimum
         * Step4: Check and find if currentElem - min > maxProfit -> set new maxProfit
         * Step5: return maxProfit outside loop
         *
         *
         * Output: Time Limit Exceeded
         * Runtime - beats 100%
         * Memory - beats 94%
         *
         * Space Complexity -> > O(n)
         * Time Complexity -> O(n)
         *
         * Verdict : Optimized
         * */
        int min = prices[0];
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if (prices[i] - min > maxProfit){
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }

}
