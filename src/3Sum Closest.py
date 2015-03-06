class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
        import sys

        closest = sum(num[:3])
        minDiff = sys.maxint
        length = len(num)
        num.sort()
        first = 0
        while first < length - 2:
            num1 = num[first]
            t = target - num1  # current target
            second = first + 1
            third = length - 1
            while second < third:
                sumLastTwo = num[second] + num[third]
                if sumLastTwo == t:
                    return target
                while second < third and sumLastTwo < t:
                    second += 1
                    if t - sumLastTwo < minDiff:
                        closest = sumLastTwo + num1
                        minDiff = target - closest
                    sumLastTwo = num[second] + num[third]
                while second < third and sumLastTwo > t:
                    third -= 1
                    if sumLastTwo - t < minDiff:
                        closest = sumLastTwo + num1
                        minDiff = closest - target
                    sumLastTwo = num[second] + num[third]
            first += 1
            while first < length - 2 and num[first] == num1:
                first += 1
        return closest


if __name__ == '__main__':
    s = Solution()
    num = [-1, 2, 1, -4]
    target = 1
    print s.threeSumClosest(num, target)