# [1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)

## Description

Given two strings `text1` and `text2`, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A *common subsequence* of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.

**Example 1:**
```
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
```

**Example 2:**
```
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
```

**Example 3:**
```
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
```

**Constraints:**

* `1 <= text1.length <= 1000`
* `1 <= text2.length <= 1000`
* The input strings consist of lowercase English characters only.

## Solution

* DP

```java
    /*
     * How does it work?
     *
     * Example: "abcde", "ace"
     *
     * +---+---+---+---+   1. i = 0 || j = 0 => some cells initialized to 0 - see matrix
     * |   | a | c | e |   
     * +---+---+---+---+
     * | a | 0   0   0
     * +---+
     * | b | 0
     * +---+
     * | c | 0
     * +---+
     * | d | 0
     * +---+
     * | e | 0
     * +---+
     * +---+---+---+---+   2. i = 1, j = 1: a[i-1] 'a' == b[j-1] 'a' => 1 + dp[i-1][j-1] = 0 + 1
     * |   | a | c | e |   
     * +---+---+---+---+   What it means? It means lcs of "a" and "a" = 1
     * | a | 0   0   0
     * +---+
     * | b | 0   1
     * +---+
     * | c | 0
     * +---+
     * | d | 0
     * +---+
     * | e | 0
     * +---+
     * +---+---+---+---+   3. i = 1, j = 2: a[i-1] 'a' != b[j-1] 'c' => max (dp[i-1][j]=0 or dp[i][j-1]=0)
     * |   | a | c | e |                       
     * +---+---+---+---+   What it means? LCS of "ab" and "ac" = 1
     * | a | 0   0   0
     * +---+
     * | b | 0   1   1
     * +---+
     * | c | 0
     * +---+
     * | d | 0
     * +---+
     * | e | 0
     * +---+
     * +---+---+---+---+   4. i = 1, j = 3: a[i-1] 'a' != b[j-1] 'e' => max (dp[i-1][j]=0 or dp[i][j-1]=0)
     * |   | a | c | e |                       
     * +---+---+---+---+   What it means? LCS of "ab" and "ace" = 1
     * | a | 0   0   0
     * +---+
     * | b | 0   1   1   1
     * +---+
     * | c | 0
     * +---+
     * | d | 0
     * +---+
     * | e | 0
     * +---+
     * +---+---+---+---+   5. i = 2, j = 1: a[i-1] 'b' != b[j-1] 'a' => max (dp[i-1][j]=1 or dp[i][j-1]=0)
     * |   | a | c | e |                       
     * +---+---+---+---+   Means: LCS of "abc" and "a" = 1 correct.
     * | a | 0   0   0
     * +---+
     * | b | 0   1   1   1
     * +---+
     * | c | 0   1
     * +---+
     * | d | 0
     * +---+
     * | e | 0
     * +---+
     * +---+---+---+---+   6. i = 2, j = 2: a[i-1] 'b' != b[j-1] 'c' => max (dp[i-1][j]=1 or dp[i][j-1]=1)
     * |   | a | c | e |                       
     * +---+---+---+---+   7. i = 2, j = 3: a[i-1] 'b' != b[j-1] 'e' => max (dp[i-1][j]=1 or dp[i][j-1]=1) 
     * | a | 0   0   0
     * +---+
     * | b | 0   1   1   1
     * +---+
     * | c | 0   1   1   1
     * +---+
     * | d | 0
     * +---+
     * | e | 0
     * +---+
     * +---+---+---+---+   8. i = 3, j = 1: a[i-1] 'c' != b[j-1] 'a' => max (dp[i-1][j]=1 or dp[i][j-1]=0)
     * |   | a | c | e |                       
     * +---+---+---+---+   9. i = 3, j = 2: a[i-1] 'c' == b[j-1] 'c' => 1 + dp[2][1] => 2
     * | a | 0   0   0
     * +---+               10. i = 3, j = 3: a[i-1] 'c' == b[j-1] 'e' => max(dp[i-1][j]=1 or dp[i][j-1]=2)
     * | b | 0   1   1   1
     * +---+
     * | c | 0   1   1   1
     * +---+
     * | d | 0   1   2   2
     * +---+
     * | e | 0
     * +---+
     * +---+---+---+---+   11. i = 4, j = 1: a[i-1] 'd' != b[j-1] 'a' => max(dp[i-1][j]=1 or dp[i][j-1]=0)
     * |   | a | c | e |                       
     * +---+---+---+---+   12. i = 4, j = 2: a[i-1] 'd' == b[j-1] 'c' => max(dp[i-1][j]=2 or dp[i][j-1]=1)
     * | a | 0   0   0
     * +---+               13. i = 4, j = 3: a[i-1] 'd' == b[j-1] 'e' => max(dp[i-1][j]=2 or dp[i][j-1]=2)
     * | b | 0   1   1   1
     * +---+
     * | c | 0   1   1   1
     * +---+
     * | d | 0   1   2   2
     * +---+
     * | e | 0   1   2   2
     * +---+
     *
     * +---+---+---+---+   14. i = 5, j = 1: a[i-1] 'e' != b[j-1] 'a' => max(dp[i-1][j]=1 or dp[i][j-1]=0)
     * |   | a | c | e |                       
     * +---+---+---+---+   15. i = 5, j = 2: a[i-1] 'e' != b[j-1] 'c' => max(dp[i-1][j]=2 or dp[i][j-1]=1)
     * | a | 0   0   0
     * +---+               16. i = 5, j = 3: a[i-1] 'e' == b[j-1] 'e' => dp[5][3] = 1 + dp[4][2] = 3 (ANSWER)
     * | b | 0   1   1   1
     * +---+
     * | c | 0   1   1   1
     * +---+
     * | d | 0   1   2   2
     * +---+
     * | e | 0   1   2   2
     * +---+
     *       0   1   2   3 <-- Answer
     */
```