class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return an integer
    def strStr(self, haystack, needle):
        lenH = len(haystack)
        lenN = len(needle)
        if lenN == 0:
            return 0
        for i in range(lenH-lenN+1):
            p = i
            q = 0
            while q < lenN and haystack[p] == needle[q]:
                p += 1
                q += 1
            if q == lenN:
                return i
        return -1


if __name__ == '__main__':
    sol = Solution()
    haystack = 'a'
    needle = 'a'
    print sol.strStr(haystack, needle)
