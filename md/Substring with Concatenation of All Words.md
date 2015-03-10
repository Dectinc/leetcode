## [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)

### Problem

You are given a string, __S__, and a list of words, __L__, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:

__S__: `"barfoothefoobarman"`

__L__: `["foo", "bar"]`

You should return the indices: `[0,9]`.

(order does not matter).

### Solution


### Code

``` Python
class Solution:
    # @param S, a string
    # @param L, a list of string
    # @return a list of integer
    def findSubstring(self, S, L):
        res = []
        if not S or not L:
            return res
        if not len(S) or not len(L):
            return res
        wl = len(L[0])   # item length
        if wl > len(S):
            return res
        wdict = {}
        for word in L:
            if not wdict.get(word):
                wdict[word] = 1
            else:
                wdict[word] += 1
        slen = len(S)
        llen = len(L)
        i = 0
        while i <= slen-wl*llen and i < wl:
            tdict = {}
            for word in L:
                tdict[word] = []
            j = i
            t = i
            count = 0
            while j <= slen:
                if count == llen:
                    res.append(j-wl*llen)
                word = S[j:j+wl]
                if word in tdict:
                    cur = len(tdict[word])
                    if cur < wdict[word]:
                        tdict[word].append(j)
                        count += 1
                    elif cur == wdict[word]:
                        nt = tdict[word][0]
                        nnt = nt
                        while nt >= t:
                            if S[nt:nt+wl] in tdict:
                                tdict[S[nt:nt+wl]].pop(0)
                            count -= 1
                            nt -= wl
                        t = nnt+wl
                        tdict[word].append(j)
                        count += 1
                else:
                    count = 0
                    for word in L:
                        tdict[word] = []
                    t = j+1
                j += wl
            i += 1
        return res
```

### Refinement
