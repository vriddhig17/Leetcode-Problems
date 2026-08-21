class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int provinces = 0;
        for(int i = 0; i < vis.length; i++) {
            if(!vis[i]) {
                provinces++;
                dfs(i, vis, isConnected);
            }
        }
        return provinces;
    }
    public void dfs(int src, boolean[] vis, int[][] isConnected) {
        vis[src] = true;
        for(int i = 0; i < isConnected.length; i++) {
            if(isConnected[src][i] == 1 && vis[i] == false) {
                dfs(i, vis, isConnected);
            }
        }
    }
}

