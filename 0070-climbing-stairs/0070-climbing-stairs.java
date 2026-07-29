class Solution {
    static int totalWays(int n, int[] dp)
    {
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];
        if(n > 1) return dp[n] = totalWays(n-1, dp) + totalWays(n-2, dp);
        return dp[n] = totalWays(n-1, dp);
    }

    public int climbStairs(int n) {
         int[] dp = new int[n+1];
         Arrays.fill(dp, -1);
         return totalWays(n, dp);
    }
}