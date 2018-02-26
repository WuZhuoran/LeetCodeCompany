public class Solution {

  public boolean isSumOfSquares(int n) {
    for(long i = 0; i*i<n; i++) {
      double root = Math.sqrt(n - i*i);
      if(Math.abs(root - Math.ceil(root)) < 1e-6) {
        return true;
      }
    }
    return false;
  }

}
