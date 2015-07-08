## [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)

### Problem

There are a total of n courses you have to take, labeled from `0` to `n - 1`.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: `[0,1]`

Given the total number of courses and a list of prerequisite __pairs__, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:
```
2, [[1,0]]
```
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is `[0,1]`
```
4, [[1,0],[2,0],[3,1],[3,2]]
```
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is `[0,1,2,3]`. Another correct ordering is `[0,2,1,3]`.

### Solution


### Code

``` Python
from collections import defaultdict

class Solution:
    # @param {integer} numCourses
    # @param {integer[][]} prerequisites
    # @return {integer[]}
    def findOrder(self, numCourses, prerequisites):
        inMap = defaultdict(set)
        outMap = defaultdict(set)
        inDegrees = [0] * numCourses
        for v, u in prerequisites:
            inMap[v].add(u)
            outMap[u].add(v)
        for k, v in inMap.iteritems():
            inDegrees[k] = len(v)

        s = [x for x in xrange(numCourses) if inDegrees[x] == 0]
        result = []
        for i in xrange(numCourses):
            if len(s) == 0:
                return []
            cur = s.pop()
            result.append(cur)
            for v in outMap[cur]:
                inD = inDegrees[v]
                if inD < 0:
                    continue
                elif inD == 1:
                    s.append(v)
                    inDegrees[v] = -1
                else:
                    inDegrees[v] -= 1
        return result
```

### Refinement
