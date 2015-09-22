# -*- coding: utf-8 -*-
# @filename 227 - Basic Calculator II
# @author   v-shijch
# @date     2015-09-22 16:06 PM
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        numbers, ops = [], [1]
        i, n = 0, len(s)
        while i < n:
            c = s[i]
            if c.isdigit():
                cur, i = int(c), i + 1
                while i < n and s[i].isdigit():
                    cur, i = cur * 10 + int(s[i]), i + 1
                if ops and ops[-1] == '*':
                    ops.pop()
                    numbers[-1] = numbers[-1] * cur
                elif ops and ops[-1] == '/':
                    ops.pop()
                    numbers[-1] = numbers[-1] / cur
                else:
                    numbers.append(cur)
                continue
            i += 1
            if c == ' ':
                continue
            elif c == '*' or c == '/':
                ops.append(c)
            else:
                ops.append(1 if c == '+' else -1)
        return sum([x * y for x, y in zip(ops, numbers)])
