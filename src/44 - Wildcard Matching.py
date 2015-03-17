class Solution:
    # @param s, an input string
    # @param p, a pattern string
    # @return a boolean
    def isMatch(self, s, p, si=0, sp=0):
        if not s or not p:
            return False
        lens = len(s)
        lenp = len(p)
        backstack = []
        while si < lens and sp < lenp:
            cp = p[sp]
            if cp == '?':
                si += 1
                sp += 1
            elif cp == '*':
                
        if si == lens and sp == lenp:
            return True
        else:
            return False