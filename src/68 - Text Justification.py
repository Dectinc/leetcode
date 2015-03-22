#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  68 - Text Justification
# @author   dectinc@icloud.com
# @date     2015-03-23 00:50

class Solution:
    # @param words, a list of strings
    # @param L, an integer
    # @return a list of strings
    def fullJustify(self, words, L):
        # if len(words) == 0 or L == 0:
        #     return []
        res = []
        lengths = []
        curLine = []
        curLength = 0
        i = 0
        while i < len(words):
            word = words[i]
            length = len(word)
            if curLength + length <= L:
                curLine.append(word)
                curLength += length + 1
                i += 1
            else:
                res.append(curLine)
                lengths.append(curLength-len(curLine))
                curLine = []
                curLength = 0
        if len(curLine) > 0:
            res.append(curLine)
            lengths.append(curLength - len(curLine))
        for i in range(len(res) - 1):
            curLine = res[i]
            res[i] = ''
            numSpaces = L - lengths[i]
            if len(curLine) == 1:
                res[i] = curLine[0] + ' '*numSpaces
            else:
                blanks = len(curLine) - 1
                avgSpaces = numSpaces / blanks
                last = numSpaces - avgSpaces * blanks
                for j in range(last):
                    res[i] += curLine[j] + ' '*(avgSpaces+1)
                for j in range(last, len(curLine)-1):
                    res[i] += curLine[j] + ' '*(avgSpaces)
                res[i] += curLine[-1]
        res[-1] = ' '.join(res[-1])
        res[-1] += ' '*(L-len(res[-1]))
        return res


if __name__ == '__main__':
    sol = Solution()
    # words = ["This", "is", "an", "example", "of", "text", "justification."]
    # L = 16
    words, L = [""], 1
    print sol.fullJustify(words, L)