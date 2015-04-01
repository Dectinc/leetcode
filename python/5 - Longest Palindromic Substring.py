__author__ = 'Dectinc'

def preProcess(s):
    return '#' + '#'.join(list(s)) + '#'

class Solution:
    # @return a string
    def longestPalindrome(self, s):
        ss = preProcess(s)
        length = len(ss)
        p = [0] * length
        c = 0
        mx = 0
        for i in range(1, length-1):
            i_mirror = 2*c - i
            if i > mx:
                p[i] = 0
            else:
                p[i] = min(mx - i, p[i_mirror])

            # Attempt to expand palindrome centered at i
            m = i+1+p[i]
            n = i-1-p[i]
            while m < length and n > -1 and ss[m] == ss[n]:
                p[i] += 1
                m += 1
                n -= 1

            if i + p[i] > mx:
                c = i
                mx = i + p[i]

        maxLen = 0
        center = 0
        for i in range(1, length):
            if p[i] > maxLen:
                maxLen = p[i]
                center = i

        return s[(center-maxLen)/2: (center+1+maxLen)/2]

if __name__ == '__main__':
    solution = Solution()
    # s = 'ababababa'
    s = 'aacabbaca'
    # s = 'abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa'
    print solution.longestPalindrome(s)
