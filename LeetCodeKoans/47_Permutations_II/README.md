# [47. Permutations II](https://leetcode.com/problems/permutations-ii/description/)

## Description

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

**Example:**

```
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
```

## Solution

* Backtrack     
  Add a boolean visited array. if visited[i] || i!=0 && candidates[i] == candidates[i-1] && !visited[i-1]
