class Solution {
    /*public int LCS(String t1, String t2, int s, int t, int dp[][])
    {
        if(s < 0 || t < 0) return 0;
        if(dp[s][t] != -1) return dp[s][t];

        if(t1.charAt(s) == t2.charAt(t)) return dp[s][t] = 1 + LCS(t1, t2, s-1, t-1, dp);
        return dp[s][t] = Math.max(LCS(t1, t2, s-1, t, dp), LCS(t1, t2, s, t-1, dp));
    }*/

    public int longestCommonSubsequence(String text1, String text2) {
        int s = text1.length();
        int t = text2.length();

        int[][] dp = new int[s + 1][t + 1];
        /*for(int i = 0; i < dp.length; i++)
        {
            Arrays.fill(dp[i],-1);
        }*/

        for(int i = 1; i <= text1.length(); i++)
        {
            for(int j = 1; j <= text2.length(); j++)
            {
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s][t];

        //return LCS(text1, text2, s-1, t-1, dp);

    }
}