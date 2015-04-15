/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.LinkedHashMap;

/**
 * @author Dectinc
 * @version Apr 15, 2015 6:33:59 PM
 * 
 */
public class LRUCache {
	private final LinkedHashMap<Integer, Integer> map;
	private final int capacity;

	public LRUCache(int capacity) {
		this.map = new LinkedHashMap<Integer, Integer>();
		this.capacity = capacity;
	}

	public int get(int key) {
		Integer result = map.get(key);
		if (result == null) {
			return -1;
		}
		map.remove(key);
		map.put(key, result);
		return result;
	}

	public void set(int key, int value) {
		Integer result = map.get(key);
		if (result == null) {
			if (map.size() == capacity) {
				map.remove(map.keySet().iterator().next());
			}
		} else {
			map.remove(key);
		}
		map.put(key, value);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
