class Solution {
    public int reverse(int x) {
        boolean flag = true;

        if (x < 0) {
            flag = false;
        }

        long l = (long) Math.abs(x);
        long result = 0;

        while(l != 0) {
            long tail = l % 10;
            long temp = result * 10 + tail;
            result = temp;
            l /= 10;
        }

        if(!flag) {
            result *= (-1);
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }


        return (int)result;
    }
}
