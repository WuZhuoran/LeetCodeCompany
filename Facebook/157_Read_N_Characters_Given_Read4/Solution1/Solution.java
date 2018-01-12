/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
import java.util.*;

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {

        char[] temp = new char[4];
        boolean eof = false;
        int total = 0;

        while(total <= n && !eof) {
            int curr = read4(temp);
            if(curr < 4) {
                eof = true;
            }

            int length = Math.min(n - total, curr);

            for(int i = 0; i < length; i++) {
                buf[total + i] = temp[i];
            }

            total += length;
        }

        return total;

    }
}
