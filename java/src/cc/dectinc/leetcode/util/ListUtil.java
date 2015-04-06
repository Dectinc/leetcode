package cc.dectinc.leetcode.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cc.dectinc.leetcode.structs.ListNode;

/**
 * @author Dectinc (i@dectinc.cc)
 * @date 2015-04-02 16:57 PM
 */
public class ListUtil {
	/**
	 * output values in a list
	 * 
	 * @param arrayList
	 * @return output string
	 */
	public static String outputArrayList(List<?> arrayList) {
		int size = arrayList.size();
		if (size == 0) {
			return "[]";
		}
		StringBuffer sb = new StringBuffer();
		sb.append('[');
		sb.append(arrayList.get(0));
		for (int i = 1; i < size; i++) {
			sb.append(", ");
			sb.append(arrayList.get(i));
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * construct a linked list by number in an array
	 * 
	 * @param numbers
	 *            values in the constructed linked list
	 * @return head of linked list
	 */
	public static ListNode constructList(Integer[] numbers) {
		return constructList(Arrays.asList(numbers));
	}

	/**
	 * construct a linked list by numbers in a list
	 * 
	 * @param numbers
	 * @return head of linked list
	 */
	public static ListNode constructList(List<Integer> numbers) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		for (Integer number : numbers) {
			ListNode node = new ListNode(number);
			p.next = node;
			p = p.next;
		}
		return head.next;
	}

	/**
	 * get the values in a linked list
	 * 
	 * @param head
	 *            head of the linked list
	 * @return values in a list
	 */
	public static List<Integer> convertLinkedListToList(ListNode head) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		while (head != null) {
			numbers.add(head.val);
			head = head.next;
		}
		return numbers;
	}
}
