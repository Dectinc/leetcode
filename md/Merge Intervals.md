## [Merge Intervals](https://leetcode.com/problems/merge-intervals/)

### Problem

Given a collection of intervals, merge all overlapping intervals.

For example,

Given `[1,3]`,`[2,6]`,`[8,10]`,`[15,18]`,

return `[1,6]`,`[8,10]`,`[15,18]`.

### Solution


### Code

``` Python
# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    # @param intervals, a list of Interval
    # @return a list of Interval
    def merge(self, intervals):
        if not intervals or len(intervals) < 2:
            return intervals
        res = []
        intervals = sorted(intervals, key=lambda interval : interval.start)
        curStart = intervals[0].start
        curEnd = intervals[0].end
        for interval in intervals[1:]:
            if interval.start > curEnd:
                res.append(Interval(curStart, curEnd))
                curStart = interval.start
                curEnd = interval.end
            else:
                curEnd = max(interval.end, curEnd)
        res.append(Interval(curStart, curEnd))
        return res
```

### Refinement
