## [Compare Version Numbers](https://leetcode.com/problems/compare-version-numbers/)

### Problem

Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, `2.5` is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

```
0.1 < 1.1 < 1.2 < 13.37
```

### Solution


### Code

``` Python
# version number like '.0.0.1' not considered
class Solution:
    # @param version1, a string
    # @param version2, a string
    # @return an integer
    def compareVersion(self, version1, version2):
        parts1 = [int(a) for a in version1.split('.')]
        parts2 = [int(a) for a in version2.split('.')]
        length1 = len(parts1)
        length2 = len(parts2)
        i = 0
        while i < min(length1, length2):
            if parts1[i] < parts2[i]:
                return -1
            elif parts1[i] > parts2[i]:
                return 1
            i += 1
        def f(x): return x != 0
        if length1 > length2 and filter(f, parts1[length2:]):
            return 1
        elif length1 < length2 and filter(f, parts2[length1:]):
            return -1
        return 0
```

### Refinement
