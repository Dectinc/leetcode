__author__ = 'Dectinc'

class Solution:
    # @param s, a string
    # @return a boolean
    def isNumber(self, s):
        if not s:
            return False
        s = s.strip()
        if len(s) == 0:
            return False
        if s[0] == '-' or s[0] == '+':
            # s = s[1:].strip().lower()
            s = s[1:].lower()
        if len(s) == 0:
            return False
        if s.startswith('.e'):
            return False
        pdot = s.find('.')
        pe = s.find('e')
        if s.rfind('.') != pdot:
            return False
        if s.rfind('e') != pe:
            return False
        if pe == 0 or pe == len(s)-1:
            return False
        if pe > 0 and pdot >= 0 and pe <= pdot:
            return False
        if pe > 0:
            s = s[:pe] + s[pe+1:]
        if pdot >= 0:
            s = s[:pdot] + s[pdot+1:]
        return s.isdigit()


if __name__ == '__main__':
    solution = Solution()
    s = '46.e3'
    print solution.isNumber(s)