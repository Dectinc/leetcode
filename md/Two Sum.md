## [Two Sum](http://oj.leetcode.com/problems/two-sum/)

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

**Input:** numbers={2, 7, 11, 15}, target=9

**Output:** index1=1, index2=2

``` java
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        int len = numbers.length;
        if (len < 2) {
            return null;
        }
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(target-numbers[0], 1);
        
        for (int i = 1; i < len; i++) {
            int curNum = numbers[i];
            if (map.containsKey(curNum)) {
                res[0] = map.get(curNum);
                res[1] = i+1;
                return res;
            } else {
                map.put(target-curNum, i+1);
            }
        }
        
        return null;
    }
}
```