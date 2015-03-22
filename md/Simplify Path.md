## [Simplify Path](https://leetcode.com/problems/simplify-path/)

### Problem

Given an absolute path for a file (Unix-style), simplify it.

For example,

__path__ = `"/home/"`, => `"/home"`

__path__ = `"/a/./b/../../c/"`, => `"/c"`

__Corner Cases__:

- Did you consider the case where __path__ = `"/../"`?
    
  In this case, you should return `"/"`.
- Another corner case is the path might contain multiple slashes `'/'` together, such as `"/home//foo/"`.
  
  In this case, you should ignore redundant slashes and return `"/home/foo"`.

### Solution


### Code

``` Python
class Solution:
    # @param path, a string
    # @return a string
    def simplifyPath(self, path):
        paths = path.split('/')
        res = []
        for p in paths:
            if p != '.' and p != '..' and p != '':
                res.append(p)
            elif p == '..' and len(res) > 0:
                res.pop()
        return '/'+'/'.join(res)
```

### Refinement
