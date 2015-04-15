## [LRU Cache](https://leetcode.com/problems/lru-cache/)

### Problem

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: `get` and `set`.

`get(key)` - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.

`set(key, value)` - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

### Solution


### Code

``` Java
public class LRUCache {
	private final java.util.LinkedHashMap<Integer, Integer> map;
	private final int capacity;

	public LRUCache(int capacity) {
		this.map = new java.util.LinkedHashMap<Integer, Integer>();
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
}
```

### Refinement
