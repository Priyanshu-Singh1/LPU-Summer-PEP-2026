class Solution {
    /*public int recur(int idx, int[] coins, int amount)
    {
        if(idx == 0) return (amount/coins[0]) * amount;

        int notTake = recur(idx - 1, coins, amount);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= amount)
        {
            take = 1 + recur(idx, coins, amount - coins[idx]);
        }
        return Math.min(take, notTake);
    }*/

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        //dp[0] = 1;
        for(int j = 0; j <= amount; j++)
        {
            if(j % coins[0] == 0)
            {
                dp[0][j] = j / coins[0];
            }
            else{
                dp[0][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j <= amount; j++)
            {
                int notTake = dp[i - 1][j];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j && dp[i][j - coins[i]] != Integer.MAX_VALUE)
                {
                    take = 1 + dp[i][j - coins[i]];
                }
                dp[i][j] = Math.min(notTake, take);
            }
        }
        int ans = dp[n-1][amount];
        return ans >= Integer.MAX_VALUE ? -1 : ans;
    }
}