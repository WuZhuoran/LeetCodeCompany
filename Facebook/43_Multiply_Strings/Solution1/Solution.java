
class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        int[] res = new int[n + m];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                int curr = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = curr + res[i + j + 1];

                res[i + j] += sum / 10;
                res[i + j + 1] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < res.length; i++) {
            if(res[i] != 0) {
                for(int j = i; j < res.length; j++) {
                    sb.append(res[j]);
                }
                break;
            }
        }

        return sb.toString().equals("") ? "0" : sb.toString();
    }
}
