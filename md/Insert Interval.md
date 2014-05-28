## [Insert Interval](https://oj.leetcode.com/problems/insert-interval/)

### Problem

Given a set of _non-overlapping_ intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

__Example 1:__

Given intervals `[1,3],[6,9]`, insert and merge `[2,5]` in as `[1,5],[6,9]`.

__Example 2:__

Given `[1,2],[3,5],[6,7],[8,10],[12,16]`, insert and merge `[4,9]` in as `[1,2],[3,10],[12,16]`.

This is because the new interval `[4,9]` overlaps with `[3,5],[6,7],[8,10]`.

### Solution


### Code

``` java
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals == null || newInterval == null) {
			return intervals;
		}

		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}

		ListIterator<Interval> it = intervals.listIterator();
		while (it.hasNext()) {
			Interval tmpInterval = it.next();
			if (newInterval.end < tmpInterval.start) {
				it.previous();
				it.add(newInterval);
				return intervals;
			} else {
				if (tmpInterval.end < newInterval.start) {
					continue;
				} else {
					newInterval.start = Math.min(tmpInterval.start,
							newInterval.start);
					newInterval.end = Math
							.max(tmpInterval.end, newInterval.end);
					it.remove();
				}
			}
		}
		intervals.add(newInterval);
		return intervals;
	}
}
```

### Refinement