class Solution:
    # @param s, an input string
    # @param p, a pattern string
    # @return a boolean
    def isMatch(self, s, p):
        lens = len(s)
        lenp = len(p)
        if lens+lenp == 0:
            return True
        if lenp - p.count('*') > lens:
            return False
        curRow = [False] * (lens + 1)
        lastRow = [False] * lens + [True]
        for i in range(lenp):
            pi = p[i]
            curRow[-1] = lastRow[-1] and pi == '*'
            if pi == '*':
                for j in range(lens):
                    curRow[j] = curRow[j - 1] or lastRow[j]
            elif pi == '?':
                for j in range(lens):
                    curRow[j] = lastRow[j - 1]
            else:
                for j in range(lens):
                    curRow[j] = lastRow[j - 1] and pi == s[j]
            lastRow = curRow[:]
        return curRow[lens-1]


if __name__ == '__main__':
    sol = Solution()
    s = 'a'
    p = '?'
    print sol.isMatch(s, p)