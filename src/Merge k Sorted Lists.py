# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class ListNode:
    def __init__(self, x, _next=None):
        self.val = x
        self.next = _next


def constructLists(arrays):
    lists = []
    for array in arrays:
        _head = None
        array = sorted(list(array))
        i = len(array) - 1
        while i >= 0:
            _head = ListNode(array[i], _head)
            i -= 1
        lists.append(_head)
    return lists


class Solution:
    # @param a list of ListNode
    # @return a ListNode
    def mergeKLists(self, lists):
        result = []
        heads = []
        i = 0
        while i < len(lists):
            l = lists[i]
            if l is not None:
                heads.append(l.val)
                i += 1
            else:
                lists.remove(l)
        while len(heads) > 0:
            minValue = min(heads)
            result.append(minValue)
            iList = heads.index(minValue)
            lists[iList] = lists[iList].next
            if lists[iList] is not None:
                heads[iList] = lists[iList].val
            else:
                del(lists[iList])
                del(heads[iList])
        return result


if __name__ == '__main__':
    sol = Solution()
    lists = [{0,1,2},{-10,-8,-5,-4},{},{},{-3},{-10,-9,-6,-4,-3,-2,-2,-1,2},{-9,-9,-2,-1,0,1},{-9,-4,-3,-2,2,2,3,3,4}]
    print sol.mergeKLists(constructLists(lists))