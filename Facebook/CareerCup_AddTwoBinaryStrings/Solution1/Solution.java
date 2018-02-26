public class Soltuion {

  public String addBinary(String a, String b) {
    String result = "";
    int s = 0; // digit sum

    int i = a.length() - 1;
    int j = b.length() - 1;

    while(i >= 0 || j >= 0 || s == 1) {
      s += ((i >= 0) ? a.charAt(i) - '0' : 0);
      s += ((j >= 0) ? b.charAt(j) - '0' : 0);

      // s == 1 or 3 -> add 1 to result
      result = char(s % 2 + '0') + result;

      // carry
      s /= 2;

      i--;
      j--;
    }

    return result;
  }

}
