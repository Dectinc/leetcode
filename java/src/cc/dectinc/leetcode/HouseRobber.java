/**
 * 
 */
package cc.dectinc.leetcode;

/**
 * @author Dectinc
 * @version Apr 21, 2015 12:22:48 AM
 * 
 */
public class HouseRobber {
	public int rob(int[] num) {
		int n = num.length;

		int last = 0;
		int pre = 0;
		for (int i = 0; i < n; i++) {
			int cur = Math.max(last + num[i], pre);
			last = pre;
			pre = cur;
		}

		return pre;
	}

	public static void main(String[] args) {
		HouseRobber sol = new HouseRobber();
		int[] num = { 1, 2, 3 };
		System.out.println(sol.rob(num));
	}

}
