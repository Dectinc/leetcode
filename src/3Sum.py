__author__ = 'Dectinc'

class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
        results = []
        if not num or len(num) < 3:
            return results
        num.sort()
        length = len(num)
        first = 0
        while first < length - 2:
            num1 = num[first]
            if num1 > 0:
                return results
            second = first + 1
            third = length - 1
            while second < third:
                while num1 + num[second] + num[third] < 0:
                    second += 1
                    if second == third:
                        break
                while num1 + num[second] + num[third] > 0:
                    third -= 1
                    if second == third:
                        break
                if second < third and num1 + num[second] + num[third] == 0:
                    results.append([num1, num[second], num[third]])
                    lastNum2 = num[second]
                    lastNum3 = num[third]
                    second += 1
                    third -= 1
                    while second < third and num[second] == lastNum2:
                        second += 1
                    while second < third and num[third] == lastNum3:
                        third -= 1
            first += 1
            while first < length - 2 and num[first] == num1:
                first += 1
        return results


if __name__ == '__main__':
    solution = Solution()
    num = [-1, 0, 1, 2, -1, -4]
    print solution.threeSum(num)