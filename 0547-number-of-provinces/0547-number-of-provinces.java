class Solution {
    public void dfs(int[][] isConnected, boolean[] vis, int node, int V)
    {
        vis[node] = true;
        for(int j = 0; j < V; j++)
        {
            if(isConnected[node][j] == 1 && !vis[j])
            {
                dfs(isConnected, vis, j, V);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] vis = new boolean[V];
        int count = 0;
        for(int i = 0; i < V; i++)
        {
            if(!vis[i])
            {
                dfs(isConnected, vis, i, V);
                count++;
            }
        }
        return count;
    }
}