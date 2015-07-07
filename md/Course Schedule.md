## [Course Schedule](https://leetcode.com/problems/course-schedule/)

### Problem

There are a total of n courses you have to take, labeled from `0` to `n - 1`.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: `[0,1]`

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:
```
2, [[1,0]]
```
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
```
2, [[1,0],[0,1]]
```
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

__Note:__

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

__Hints:__

- This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
- Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
- Topological sort could also be done via BFS.

### Solution


### Code

``` Python
class Solution:
    # @param {integer} numCourses
    # @param {integer[][]} prerequisites
    # @return {boolean}
    def canFinish(self, numCourses, prerequisites):
        preMap, degrees = self.makeMap(numCourses, prerequisites)
        for _i in xrange(numCourses):
            if 0 not in degrees:
                return False
            courseId = degrees.index(0)
            degrees[courseId] = -1
            for v in preMap.get(courseId, set()):
                degrees[v] -= 1
        return True

    def makeMap(self, numCourses, prerequisites):
        degrees = [0] * numCourses
        preMap = {}
        edges = sorted(prerequisites)
        dedupEdges = [edges[i] for i in xrange(len(edges)) if i == 0 or edges[i] != edges[i-1]]
        for v, u in dedupEdges:
            vset = preMap.get(u, set())
            vset.add(v)
            preMap[u] = vset
            degrees[v] += 1
        return preMap, degrees
```

### Refinement
