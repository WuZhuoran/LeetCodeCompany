
class Solution {
    public char[][] grid;

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length < 1) {
            return 0;
        }

        this.grid = grid;

        int count = 0;

        for(int i = 0; i < this.grid.length; i++) {
            for(int j = 0; j < this.grid[0].length; j++) {
                if(this.grid[i][j] == '1') {
                    dfs(i,j);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j) {
        if(i < 0 || j < 0 || i >= this.grid.length || j >= this.grid[0].length || this.grid[i][j] != '1') {
            return;
        }

        this.grid[i][j] = '0';

        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);

    }
}
