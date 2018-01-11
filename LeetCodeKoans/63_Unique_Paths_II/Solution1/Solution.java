public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int length = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        
        int[] road = new int[width];
        road[0] = 1;
        
        for(int i = 0; i < length; i ++) {
            for (int j = 0; j < width; j ++) {
                if(obstacleGrid[i][j] == 1) {
                    road[j] = 0;
                } else if(j != 0) {
                    road[j] += road[j - 1];
                }
            }
        }
        
        return road[width - 1];
        
    }
}
