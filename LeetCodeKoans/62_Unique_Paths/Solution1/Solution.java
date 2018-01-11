public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
            return 1;
        }
        
        int[][] grid = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0){
                    grid[i][j] = 1;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i != 0 && j != 0){
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }
        
        return grid[m-1][n-1];
    }
}
