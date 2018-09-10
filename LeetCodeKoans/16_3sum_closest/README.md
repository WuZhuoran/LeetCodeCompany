# [16. 3Sum Closest](https://leetcode.com/problems/3sum-closest/description/)

## Description

Given an array `nums` of *n* integers and an integer `target`, find three integers in `nums` such that the sum is closest to `target`. Return the sum of the three integers. You may assume that each input would have exactly one solution.

**Example:**

```
Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

## Solution

Two Pointers, Sort first, then add from 2 sides.

Concern 2 things, 1) when to update sum, 2) when to update pointers.
