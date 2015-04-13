/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.HashMap;

import cc.dectinc.api.structs.RandomListNode;

/**
 * @author Dectinc
 * @version Apr 13, 2015 9:06:24 PM
 * 
 */
public class CopyListWithRandomPointer {
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
