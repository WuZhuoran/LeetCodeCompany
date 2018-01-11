public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList();
        
        if(matrix.length == 0) {
            return list;
        }
        
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length;
        int colEnd = matrix[0].length;
        
        while(rowStart < rowEnd && colStart < colEnd) {
            for(int i = colStart; i < colEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
            rowStart++;
            
            for(int i = rowStart; i < rowEnd; i++) {
                list.add(matrix[i][colEnd - 1]);
            }
            colEnd--;
            
            if(rowStart < rowEnd) {
                for(int i = colEnd - 1; i >= colStart; i--) {
                    list.add(matrix[rowEnd - 1][i]);
                }
                rowEnd--;
            }
            
            if(colStart < colEnd) {
                for(int i = rowEnd - 1; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        
        return list;
    }
}
