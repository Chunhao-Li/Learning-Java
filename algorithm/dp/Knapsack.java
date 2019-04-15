package algorithm.dp;

/**
 * @author GeeksforGeeks
 */
public class Knapsack {

    public static void main(String[] args) {
        int val[] = {10, 30, 20};
        int[] wt = new int[] {5, 10, 15};
        int W = 100;
        int n = val.length;
        System.out.println(KnapsackDP.knapSack(W, wt, val, n));
        System.out.println(UnboundedKnapsack.unboundedKnapsack(W, n, val, wt));
    }

}

// Basic recursion
class KnapsackBasic {
    // A utility function that returns maximum of two integers
    static int max(int a, int b) {return (a>b) ? a : b;}

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int[] wt, int[] val, int n) {
        // Base Case
        if (n == 0 || W == 0) {
            return 0;
        }

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n-1] > W) {
            return knapSack(W, wt, val, n-1);
        }

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        else {
            return max(val[n-1] + knapSack(W-wt[n-1],wt ,val ,n-1),
                    knapSack(W, wt, val, n-1));
        }

    }
}

// A Dynamic Programming based solution for 0-1 Knapsack problem
class KnapsackDP {
    static int max(int a, int b) {return (a>b) ? a : b;}

    static int knapSack(int W, int[] wt, int[] val, int n) {
        int i,w;
        int[][] K = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i =0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i==0 || w==0) {
                    K[i][w] = 0;
                }
                else if (wt[i-1] <= w) {
                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],
                            K[i-1][w]);
                }
                else {
                    K[i][w] = K[i-1][w];
                }
            }
        }

        return K[n][W];
    }
}

// multiple instances allowed
class UnboundedKnapsack {
    private static int max(int i, int j) {return (i>j) ? i:j;}

    public static int unboundedKnapsack(int W, int n, int[] val,
                                         int[] wt) {
        // dp[i] is going to store maximum value
        // with knapsack capacity W.
        int[] dp = new int[W+1];
//        for (int i : dp) {
//            System.out.println(i);
//        }

        // Fill dp[] using above recursive formula
        for (int w =0; w <= W; w++) {
            for (int j =0; j <= n-1; j++) {
                if (wt[j] <= w ) {
                    dp[w] = max(dp[w], dp[w - wt[j]] + val[j]);
                }
            }
        }
        return dp[W];
    }
}

