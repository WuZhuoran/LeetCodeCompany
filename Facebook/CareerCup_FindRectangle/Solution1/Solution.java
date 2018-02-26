public class Solution {

  public boolean findRectangle(int[][] m) {
     for(int i = 0; i < m.length; i++) {
       for(int j = 0; j < m[0].length; j++) {
         if(m[i][j] == 1) {
           for(int ii = i + 1; ii < m.length; ii++) {
             for(int jj = j + 1; jj < m[0].length; jj++) {
               if(m[i][jj] == 1 && m[ii][j] == 1 && m[ii][jj] == 1){
                 return true;
               }
             }
           }
         }
       }
     }

     return false;
  }

  public boolean betterFindRectangle(int[][] m) {
    
  }

}
