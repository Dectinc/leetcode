## [Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/)

### Problem

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given `"25525511135"`,

return [`"255.255.11.135"`, `"255.255.111.35"`]. (Order does not matter)

### Solution


### Code

``` Python
class Solution:
    # @param s, a string
    # @return a list of strings
    def restoreIpAddresses(self, s, need=4):
        result = []
        length = len(s)
        if length < need or length > 3*need:
            return result
        if need == 1 and not (s[0] == '0' and len(s)>1) and not int(s) > 255:
            return [s]
        for i in range(1,4):
            if int(s[:i]) > 255:
                continue
            if s[0] == '0' and i > 1:
                continue
            tmp = self.restoreIpAddresses(s[i:], need-1)
            for a in tmp:
                result.append(s[:i] + '.' + a)
        return result
```

### Refinement
