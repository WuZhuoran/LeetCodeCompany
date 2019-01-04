import java.io.*;
import java.util.*;
import java.lang.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

 Write a function that takes this input as a parameter and returns a data structure containing the number of hits that were recorded on each domain AND each domain under it. For example, an impression on "mail.yahoo.com" counts for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains.)

Sample output (in any order):
1320    com
 900    google.com
 410    yahoo.com
  60    mail.yahoo.com
  10    mobile.sports.yahoo.com
  50    sports.yahoo.com
  10    stackoverflow.com
   3    org
   3    wikipedia.org
   2    en.wikipedia.org
   1    es.wikipedia.org
   1    mobile.sports
   1    sports


We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order and no URL was visited more than once per person.

Write a function that takes two user’s browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample output:

f(user0, user2):
   /pink.php
   /register.asp
   /orange.html

f(user1, user2):
   /green.html
   /blue.html
   /pink.php
   /register.asp

f(user0, user3):
   (empty)

f(user1, user3):
   /blue.html

 */

class Solution {
  public static void main(String[] args) {
    String[] counts = {
        "900,google.com",
        "60,mail.yahoo.com",
        "10,mobile.sports.yahoo.com",
        "40,sports.yahoo.com",
        "300,yahoo.com",
        "10,stackoverflow.com",
        "2,en.wikipedia.org",
        "1,es.wikipedia.org",
        "1,mobile.sports"
    };

    Map<String, Integer> m = domainCount(counts);

    for (String key : m.keySet()) {
      //res.add(map.get(key).toString() + " " + key);
      System.out.println(m.get(key).toString() + " " + key);
    }

    List<String> user0 = Arrays.asList(
    "/start.html", "/pink.php", "/register.asp", "/orange.html", "/red.html" );
    List<String> user1 = Arrays.asList(
        "/red.html", "/green.html", "/blue.html", "/pink.php", "/register.asp");
    List<String> user2 = Arrays.asList(
        "/start.html", "/green.html", "/blue.html", "/pink.php", "/register.asp",
        "/orange.html");
    List<String> user3 = Arrays.asList("/blue.html", "/logout.php");

    solution(user0, user2);

  }

  public static void solution(List<String> a, List<String> b) {
    /*

    m ,n

    L(m,n) = Max_1,i,j,m,n (L(m-1, n-1) + 1 , 0) // m-1 == n-1

    */

    int m = a.size();
    int n = b.size();

    int[][] dp = new int[m+1][n+1];

    int len = 0;
    int row = 0;
    int col = 0;

    for (int i = 0 ; i <= m ; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j ==0) {
          dp[i][j] = 0;
        } else if(a.get(i - 1).equals(b.get(j - 1))) {
          dp[i][j] = dp[i-1][j-1] + 1;

          if (dp[i][j] > len) {
            len = dp[i][j];
            row = i;
            col = j;
          }

        } else {
          dp[i][j] = 0;
        }
      }
    }

    String res = "";

    while(dp[row][col] != 0) {

      res = a.get(row)  + " " + res;

      len --;
      row --;
      col --;
    }

    System.out.println(res);

  }

  public static Map<String, Integer> domainCount(String[] counts) {
    HashMap<String, Integer> map = new HashMap<>();


    for (int i = 0; i < counts.length; i++) {
      String[] parts = counts[i].split(",");
      int hits = Integer.valueOf(parts[0]);
      String[] domains = parts[1].split("\\.");

      int length = domains.length;
      String make = "";


      for (int j = length - 1; j >= 0; j--) {

        make = domains[j] + "." + make;
        int l = make.length();
        String temp = make.substring(0, l-1);

        if (map.containsKey(temp)) {
          // update value
          map.put(temp, map.get(temp) + hits);
        } else {
          map.put(temp, hits);
        }
      }

    }

    return map;
  }
}
