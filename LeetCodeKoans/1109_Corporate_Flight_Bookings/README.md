# 1109. Corporate Flight Bookings](https://leetcode.com/problems/corporate-flight-bookings/)

## Description

There are `n` flights, and they are labeled from `1` to `n`.

We have a list of flight bookings.  The `i`-th booking `bookings[i] = [i, j, k]` means that we booked `k` seats from flights labeled `i` to `j` inclusive.

Return an array `answer` of length `n`, representing the number of seats booked on each flight in order of their label.

**Example 1:**
```
Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
Output: [10,55,45,25,25]
```

**Constraints:**
* `1 <= bookings.length <= 20000`
* `1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000`
* `1 <= bookings[i][2] <= 10000`

## Solution

* Solution1: linear.

* prefix sum

```
Let's solve this problem by taking another view: to calculate how many passengers at each bus stop.

Think all the flights are combined as a busline and each flight as a bus stop. And for each flight booking, we can restate as following:
Assume bookings: [[1,2,10],[2,3,20],[3,5,25]],and n=5
For booking : [1,2,10], it can be restated as : 10 passengers aboard at bus stop 1 and alight at bus stop 3(2+1)
For booking : [2,3,20], it can be restated as : 20 passengers aboard at bus stop 2 and alight at bus stop 4(3+1)
For booking : [3,5,25], it can be restated as : 25 passengers aboard at bus stop 3 and alight at bus stop 6(5+1). It doesn't matter whether stop 6 exists because we just consider 5 stops(n=5)

Then the problem can be restaed as : How many passengers in the bus at the each bus stop[i] (namely result[i])?

From this view, the problem become simpler.
To solve this problem, we need a status[i] to store the total people aboard or alight at bus stop[i] (positive means aboard and negetive means alight) , and then, just accumulate from status[0] to status[i] to calculate the how many passengers in the bus at each stopi.
Notice the number of passengers at stop[i] is equal to the number of passengers at stop[i] plus the status[i], result[i] = result[i-1] + status[i]
```
