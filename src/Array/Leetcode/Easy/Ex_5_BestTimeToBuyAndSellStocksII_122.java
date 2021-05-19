package Array.Leetcode.Easy;

public class Ex_5_BestTimeToBuyAndSellStocksII_122 {

    public int maxProfit(int[] prices) {
        // [7,1,5,3,6,4]

        return calculate(prices,0);

    }

    public int calculate(int [] prices, int s){

        System.out.println("Starting function for s= "+s );
        if(s >= prices.length){
            return 0;
        }

        int max=0;
        for(int start = s; start < prices.length; start ++){

            int maxProfit = 0;
            for(int i = start +1; i < prices.length; i++){
                if(prices[start] < prices[i] ){
                    int profit = calculate(prices, i+1) + prices[i] - prices[start];

                    if(profit > maxProfit){
                        maxProfit = profit;
                    }
                }
            }

            if(maxProfit > max){
                max = maxProfit;
            }
        }
        System.out.println(">>>>>> Returning "+max);
        return max;
    }

//    public int rec(int index, int stock, int tr, int [] arr){
//        if(stock == 0){
//            // buy + dont buy
//            return  max(rec(index+1,1, tr, arr) - arr[index], rec(index+1,0,tr, arr));
//        }
//
//        if(stock == 1){
//            // sell + don't sell
//            return max(rec(index+1, 0, tr+1, arr) + arr[index], rec(index+1,1,tr, arr));
//        }
//
//
//
//    }

    public static void main(String args []){
        Ex_5_BestTimeToBuyAndSellStocksII_122 obj = new Ex_5_BestTimeToBuyAndSellStocksII_122();
//        int [] arr = {7,1,2,5,3,1,4,6};
//        int result = obj.maxProfit(arr);
//        System.out.println("--------------");
//        System.out.println(result);
//
//        for (int i = 8; i<8; i++){
//            System.out.println("hello");
//        }

        int [] arr = {9,2,8};


//        int profit = obj.rec(0,0,0,arr);
    }

}
