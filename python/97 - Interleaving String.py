class Solution:
    # @return a boolean
    def isInterleave(self, s1, s2, s3):
        if len(s3) != len(s1) + len(s2):
            return False
        if not s1:
            return s2 == s3
        if not s2:
            return s1 == s3
        p = []
        len1 = len(s1)
        len2 = len(s2)
        for i in range(len1 + 1):
            p.append([False] * (len2+1))
        p[0][0] = True
        for i in range(len1+1):
            for j in range(len2+1):
                k = i+j
                if i > 0 and s1[i-1] == s3[k-1]:
                    p[i][j] = p[i][j] or p[i-1][j]
                if j > 0 and s2[j-1] == s3[k-1]:
                    p[i][j] = p[i][j] or p[i][j-1]
        return p[len1][len2]



    def isInterleave1(self, s1, s2, s3):
        if len(s3) != len(s1) + len(s2):
            return False
        if not s1:
            return s2 == s3
        if not s2:
            return s1 == s3
        match = False
        if s1[0] == s3[0]:
            match = match or self.isInterleave(s1[1:], s2, s3[1:])
        if s2[0] == s3[0]:
            match = match or self.isInterleave(s1, s2[1:], s3[1:])
        return match


if __name__ == '__main__':
    solution = Solution()
    # s1 = 'a'
    # s2 = 'b'
    # s3 = 'ab'
    s1 = 'bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa'
    s2 = 'babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab'
    s3 = 'babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab'
    print solution.isInterleave(s1, s2, s3)
