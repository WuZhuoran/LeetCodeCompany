# [325. Maximum Size Subarray Sum Equals k](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/)

## Description

Given an array *nums* and a target value *k*, find the maximum length of a subarray that sums to *k*. If there isn't one, return 0 instead.

**Note:**    
The sum of the entire *nums* array is guaranteed to fit within the 32-bit signed integer range.

**Example 1:**    
Given *nums* = `[1, -1, 5, -2, 3]`, *k* = `3`,     
return `4`. (because the subarray `[1, -1, 5, -2]` sums to `3` and is the longest)

**Example 2:**     
Given *nums* = `[-2, -1, 2, 1]`, *k* = `1`,    
return `2`. (because the subarray `[-1, 2]` sums to `1` and is the longest)

**Follow Up:**    
Can you do it in O(*n*) time?


## Solution

> The HashMap stores the sum of all elements before index i as key, and i as value. For each i, check not only the current sum but also (currentSum - previousSum) to see if there is any that equals k, and update max length.
