## [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)

### Problem

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list. 

### Solution


### Code

``` Java
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	HashMap<Integer, RandomListNode> nodeMap = new HashMap<Integer, RandomListNode>();

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode root = new RandomListNode(-1);
		RandomListNode p = root;

		while (head != null) {
			int curLabel = head.label;
			RandomListNode node = getNode(curLabel);
			if (head.random != null) {
				RandomListNode randomNode = getNode(head.random.label);
				node.random = randomNode;
			}
			p.next = node;
			p = p.next;
			head = head.next;
		}
		return root.next;
	}

	public RandomListNode getNode(int label) {
		RandomListNode node;
		if (nodeMap.containsKey(label)) {
			node = nodeMap.get(label);
		} else {
			node = new RandomListNode(label);
			nodeMap.put(label, node);
		}
		return node;
	}
}
```

### Refinement
