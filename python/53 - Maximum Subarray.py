__author__ = 'Dectinc'

def maxSubArrayGivenRange(A, start, end):
    if start >= end:
        return A[end]
    mid = (start + end) / 2
    maxLeft = maxSubArrayGivenRange(A, start, mid)
    maxRight = maxSubArrayGivenRange(A, mid+1, end)
    p = mid-1
    maxMidLeft = A[mid]
    tmpSum = maxMidLeft
    while p >= start:
        tmpSum += A[p]
        maxMidLeft = max(maxMidLeft, tmpSum)
        p -= 1
    p = mid+2
    maxMidRight = A[mid+1]
    tmpSum = maxMidRight
    while p <= end:
        tmpSum += A[p]
        maxMidRight = max(maxMidRight, tmpSum)
        p += 1
    maxSum = max(maxLeft, maxRight)
    return max(maxSum, maxMidLeft + maxMidRight)

class Solution:
    # @param A, a list of integers
    # @return an integer
    def maxSubArray(self, A):
        return maxSubArrayGivenRange(A, 0, len(A)-1)


if __name__ == '__main__':
    solution = Solution()
    A = [8,-19,5,-4,20]
    print solution.maxSubArray(A)