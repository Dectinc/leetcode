class Solution:
    # @param num, a list of integer
    # @return nothing (void), do not return anything, modify num in-place instead.
    def nextPermutation(self, num):
        def reverse(i, j):
            while i < j:
                a = num[i]
                num[i] = num[j]
                num[j] = a
                i += 1
                j -= 1
        if not num:
            return
        length = len(num)
        if length < 2:
            return
        i = length - 2
        while i >= 0 and num[i] >= num[i+1]:
            i -= 1
        if i == -1:
            reverse(0, length-1)
            return
        j = length - 1
        while j > i:
            if num[j] > num[i]:
                a = num[i]
                num[i] = num[j]
                num[j] = a
                break
            j -= 1
        reverse(i+1, length - 1)


if __name__ == '__main__':
    sol = Solution()
    num = [6, 8, 7, 4, 3, 2]
    sol.nextPermutation(num)
    print num