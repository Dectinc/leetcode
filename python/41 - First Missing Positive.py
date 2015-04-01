__author__ = 'Dectinc'

class Solution:
    # @param A, a list of integers
    # @return an integer
    def firstMissingPositive(self, A):
        if not A or len(A) == 0:
            return 1
        i = 0
        while i < len(A):
            a = A[i]
            if a > 0 and a <= len(A) and a != i+1 and A[a-1] != A[i]:
                A[i], A[a-1] = A[a-1], A[i]
            else:
                i += 1
        for i,a in enumerate(A):
            if a != i+1:
                return i+1
        return len(A)+1


if __name__ == '__main__':
    sol = Solution()
    A = [1,1]
    print sol.firstMissingPositive(A)