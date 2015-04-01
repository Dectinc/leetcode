class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]
    def searchRange(self, A, target):
        left = self.binarySearch(A, target-0.5)
        if A[left] != target:
            return [-1, -1]
        A.append(0)
        right = self.binarySearch(A, target+0.5)
        return [left, right-1]

    def binarySearch(self, A, target):
        start, end = 0, len(A)-1
        while start < end:
            mid = (start+end)/2
            if A[mid] > target:
                end = mid
            else:
                start = mid+1
        return start
