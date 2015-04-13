/**
 * 
 */

package cc.dectinc.leetcode;

/**
 * @author chenshijiang
 * @date Apr 13, 2015 4:57:59 PM
 * 
 */
public class Candy {
	public int candy(int[] ratings) {
		int length = ratings.length;
		int amount = 1, last = 1, falling = 0;
		for (int i = 1; i < length; i++) {
			if (ratings[i] >= ratings[i - 1]) {
				if (falling > 0) {
					amount += falling * (falling + 1) / 2;
					if (falling >= last) {
						amount += falling - last + 1;
					}
					falling = 0;
					last = 1;
				}
				last = ratings[i] == ratings[i - 1] ? 1 : last + 1;
				amount += last;
			} else {
				falling++;
			}
		}
		if (falling > 0) {
			amount += falling * (falling + 1) / 2;
			if (falling >= last) {
				amount += falling - last + 1;
			}
		}
		return amount;
	}

	public static void main(String[] args) {
		Candy sol = new Candy();
		int[] ratings = { 1, 2, 4, 2, 2 };
		System.out.println(sol.candy(ratings));
	}

}
