class Solution:
    # @return a string
    def convert(self, s, nRows):
        if nRows == 1:
            return s
        if not s:
            return ''
        collections = [''] * nRows
        length = len(s)
        loop = 2*nRows - 2
        for i in range(length):
            zig = i % loop
            collections[nRows-1-abs(zig-nRows+1)] += s[i]
        return ''.join(collections)


if __name__ == '__main__':
    solution = Solution()
    s = 'ABC'
    n = 3
    print solution.convert(s, n)