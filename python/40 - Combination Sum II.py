__author__ = 'Dectinc'

class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
    def __init__(self):
        self.output = []

    def combinationSum2(self, candidates, target, temp = None, pos = 0):
        if temp is None:
            candidates.sort()
        temp = temp or []

        if target == 0:
            self.output.append(temp[:])
            return

        last = None
        for i in range(pos, len(candidates)):
            num = candidates[i]
            if target - num < 0:
                break
            if last == num:
                continue

            last = num
            temp.append(num)
            self.combinationSum2(candidates, target - num, temp, i + 1)
            temp.pop()

        return self.output


if __name__ == '__main__':
    sol = Solution()
    candidates = [1]
    target = 1
    print sol.combinationSum(candidates, target)
