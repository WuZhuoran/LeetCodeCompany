class Soltion {

  public int longestSubstring(String s, int k) {
    LinkedList<Character> l = new LinkedList<>();

    int slow = 0;
    int fast = 0;
    int max = 0;

    while(fast < s.length()) {
      char c = s.charAt(fast);

      if(l.contains(c)) {
        //TODO
      }
    }

    return max;
  }

}
