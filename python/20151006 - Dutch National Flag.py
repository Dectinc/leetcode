# -*- coding: utf-8 -*-
# @filename 20151006 - Dutch National Flag
# @author   Dectinc
# @date     2015-10-06 10:12 AM

import random

def solution(A):
    n = len(A)
    if n < 2:
        return A
    i, j, k = 0, 0, n-1
    while j < k:
        if A[j] == 0:
            A[i], A[j] = A[j], A[i]
            i += 1
            j += 1
        elif A[j] == 2:
            A[j], A[k] = A[k], A[j]
            k -= 1
        else:
            j += 1
    return A

if __name__ == '__main__':
    A = [random.randrange(3) for _ in xrange(random.randrange(10, 40))]
    print A
    print [A.count(x) for x in range(3)]
    B = solution(A)
    print solution(B)
    print [B.count(x) for x in range(3)]
    print [B.index(x) for x in range(3)]