class Solution {
    public int divide(int dividend, int divisor) {
        boolean flag = true;
        if (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) {
            flag = true;
        } else {
            flag = false;
        }

        long divid = Math.abs((long)dividend);
        long divis = Math.abs((long)divisor);

        if(divid == 0 || divid < divis) {
            return 0;
        }

        if (divid == divis) {
            return flag ? 1 : -1;
        }

        long multiple = 0;

        while(divid >= divis) {
            long sum = divis;
            long temp = 1;
            while ((sum+sum) <= divid) {
                sum += sum;
                temp += temp;
            }
            //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
            multiple += temp;
            divid -= sum;
        }

        if (multiple > Integer.MAX_VALUE) {
            return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (!flag) {
            multiple *= -1;
        }

        return (int) multiple;
    }
}
