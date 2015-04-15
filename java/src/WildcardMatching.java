/**
 * 
 */

/**
 * @author Dectinc
 * @version Apr 15, 2015 11:32:10 AM
 * 
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		int lens = s.length();
		int lenp = p.length();
		if (p.replace("*", "").length() > lens) {
			return false;
		}
		boolean[] cur = new boolean[lenp + 1];
		boolean[] prev = new boolean[lenp + 1];

		char[] ss = s.toCharArray();
		char[] pp = p.toCharArray();
		prev[0] = true;
		for (int i = 0; i < lenp; i++) {
			if (pp[i] != '*') {
				break;
			}
			prev[i + 1] = true;
		}

		for (int i = 0; i < lens; i++) {
			for (int j = 0; j < lenp; j++) {
				if (pp[j] == '*') {
					cur[j + 1] = prev[j + 1] || cur[j];
				} else {
					cur[j + 1] = prev[j] && (pp[j] == '?' || pp[j] == ss[i]);
				}
			}
			prev = cur;
			cur = new boolean[lenp + 1];
		}

		return prev[lenp];
	}

	public static void main(String[] args) {
		WildcardMatching sol = new WildcardMatching();
		String s = "aa";
		String p = "aa";
		System.out.println(sol.isMatch(s, p));
	}
}
