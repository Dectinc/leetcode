## [Text Justification](https://leetcode.com/problems/text-justification/)

### Problem

Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,

__words__: `["This", "is", "an", "example", "of", "text", "justification."]`

__L__: `16`.

Return the formatted lines as:
```
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
```
__Note:__ Each word is guaranteed not to exceed L in length. 

__Corner Cases__:

 - A line other than the last line might contain only one word. What should you do in this case?
    In this case, that line should be left-justified.

### Solution


### Code

``` Python
class Solution:
    # @param words, a list of strings
    # @param L, an integer
    # @return a list of strings
    def fullJustify(self, words, L):
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
```

### Refinement
