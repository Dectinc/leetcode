/**
 * 
 */

package cc.dectinc.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import cc.dectinc.api.structs.UndirectedGraphNode;

/**
 * @author chenshijiang
 * @date Apr 12, 2015 4:56:52 PM
 * 
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		HashSet<Integer> doneNodes = new HashSet<Integer>();
		HashMap<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> nodes = new LinkedList<UndirectedGraphNode>();
		nodes.add(node);
		UndirectedGraphNode root = new UndirectedGraphNode(node.label);
		Queue<UndirectedGraphNode> newNodes = new LinkedList<UndirectedGraphNode>();
		newNodes.add(root);
		nodeMap.put(root.label, root);

		while (!nodes.isEmpty()) {
			UndirectedGraphNode curNode = nodes.poll();
			UndirectedGraphNode newNode = newNodes.poll();
			if (doneNodes.contains(curNode.label)) {
				continue;
			}
			for (UndirectedGraphNode nextNode : curNode.neighbors) {
				UndirectedGraphNode newNextNode;
				if (nodeMap.containsKey(nextNode.label)) {
					newNextNode = nodeMap.get(nextNode.label);
				} else {
					newNextNode = new UndirectedGraphNode(nextNode.label);
					nodeMap.put(newNextNode.label, newNextNode);
				}
				newNode.neighbors.add(newNextNode);
				nodes.offer(nextNode);
				newNodes.offer(newNextNode);
			}
			doneNodes.add(curNode.label);
		}

		return root;
	}

	public static void main(String[] args) {
	}
}
