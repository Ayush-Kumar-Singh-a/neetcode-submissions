class Solution {
    private void dfs(int row, int col, int iniColor, int[][] ans, int[][] image, int[] delrow, int[] delcol, int color){
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i = 0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == iniColor && ans[nrow][ncol] != color){
                dfs(nrow, ncol, iniColor, ans, image, delrow, delcol, color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int iniColor = image[sr][sc];
       int[][] ans = image;
       int[] delrow = {-1, 1, 0, 0};
       int[] delcol = {0, 0, -1, 1};
       dfs(sr, sc, iniColor, ans, image, delrow, delcol, color);
       return ans; 
    }
}