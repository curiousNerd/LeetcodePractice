package Array.Leetcode.Easy;

public class Ex_6_FibonacciNumber_509 {

    public int fib_recursion(int n) {

        /**
         * This is a bruteForce solution which uses recursion to solve the problem
         * the function uses the recursion relation F(n) = F(n-1) + F(n-2)
         *
         * Output: Accepted
         *
         * Space Complexity -> O(n)
         * We need space proportionate to N to account for the max size of the stack, in memory.
         * This stack keeps track of the function calls to fib(N).
         * This has the potential to be bad in cases that there isn't enough physical memory to
         * handle the increasingly growing stack, leading to a StackOverflowError.
         * The Java docs have a good explanation of this,
         * describing it as an error that occurs because an application recurses too deeply.
         *
         * Time Complexity -> O(2^n)
         * It takes exponential time
         * The amount of operations needed,
         * for each level of recursion, grows exponentially as the depth approaches N.
         *
         * */

        if(n <= 1){
            return n;
        }

        return fib_recursion(n-1) + fib_recursion(n-2);

    }

    public int fib_memoization_bottom_up(int n){

        /**
         * In computing, memoization is an optimization technique used primarily to speed up computer programs
         * by storing the results of expensive function calls and returning the cached result when
         * the same inputs occur again.
         *
         * Here we ae creating a cache (array) with all the values for fibonacci and returning once all the
         * values are computed
         *
         * Space Complexity: O(n) - size of Data Structure is proportionate to n
         * Time Complexity: O(n) - Loop runs from 2 to N and then )(1) is used to access the
         *                          elements later on
         * */

        if(n <= 1){
            return n;
        }

        return memoize(n);
    }

    private int memoize(int n){

        int [] cache = new int[n+1];
        cache[1] = 1;

        for(int i=2; i<=n; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[n];
    }

    }
