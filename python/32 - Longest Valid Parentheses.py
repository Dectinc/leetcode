class Solution:
    # @param s, a string
    # @return an integer
    def longestValidParentheses(self, s):
        if not s or len(s) < 2:
            return 0
        longest = 0
        left = -1
        stack = []
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                if len(stack) == 0:
                    left = i
                else:
                    stack.pop()
                    if len(stack) == 0:
                        longest = max(longest, i-left)
                    else:
                        longest = max(longest, i-stack[-1])
        return longest


if __name__ == '__main__':
    sol = Solution()
    # s = ')()(((())))('
    s = '())()'
    print sol.longestValidParentheses(s)