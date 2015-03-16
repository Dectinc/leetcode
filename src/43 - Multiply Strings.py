__author__ = 'Dectinc'

class Solution:
    # @param num1, a string
    # @param num2, a string
    # @return a string
    def multiply(self, num1, num2):
        res = '0'
        if not num1 or not num2:
            return res
        if len(num1) == 0 or len(num2) == 0:
            return res
        isNegative = False
        if num1[0] == '-':
            num1 = num1[1:]
            isNegative = not isNegative
        if num2[0] == '-':
            num2 = num2[1:]
            isNegative = not isNegative
        length1 = len(num1)
        length2 = len(num2)
        length = length1 + length2
        list1 = [int(num1[i]) for i in range(length1-1, -1, -1)]
        list2 = [int(num2[i]) for i in range(length2-1, -1, -1)]
        res = [0] * length
        for i in range(length1):
            for j in range(length2):
                cur = list1[i] * list2[j]
                res[i+j] += cur%10
                res[i+j+1] += cur/10
        for i in range(length-1):
            res[i+1], res[i] = res[i+1]+res[i]/10, res[i]%10
        res.reverse()
        i = 0
        while i < length:
            if res[i] > 0:
                res = res[i:]
                break
            i += 1
        if i == length:
            return '0'
        if isNegative:
            res.insert(0, '-')
        return ''.join([str(a) for a in res])

if __name__ == '__main__':
    sol = Solution()
    num1 = '1'
    num2 = '1'
    print sol.multiply(num1, num2)