public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        
        if(matrix[0].length == 0) {
            return false;
        }
        
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        
        int length = matrix.length;
        int width = matrix[0].length;
        
        if(target < matrix[0][0] || target > matrix[length - 1][width - 1]) {
            return false;
        }
        
        if(length == 1) {
            for(int j = 0; j < width; j++) {
                if(target == matrix[0][j]) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                if(target <= matrix[i][width - 1] && target >= matrix[i][0]) {
                    // target might exist in row i
                    for(int j = 0; j < width; j++) {
                        if(target == matrix[i][j]) {
                            return true;
                        }
                    }
            }
        }
        }
        

        
        return false;
    }
}
