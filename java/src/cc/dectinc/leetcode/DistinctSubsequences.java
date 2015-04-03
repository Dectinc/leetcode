package cc.dectinc.leetcode;

/**
 * @author Dectinc (i@dectinc.cc)
 * @date 2015-04-03 22:40 PM
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int lenS = S.length();
        int lenT = T.length();
        if (lenS < lenT || lenT == 0) {
            return 0;
        }
        int[] lastRow = new int[lenS+1];
        int[] curRow = new int[lenS+1];
        for (int i = 0; i <= lenS; i++) {
            lastRow[i] = 1;
        }
        for (int i = 0; i < lenT; i++) {
            for (int j = 0; j < lenS; j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    curRow[j+1] = curRow[j] + lastRow[j];
                } else {
                    curRow[j+1] = curRow[j];
                }
            }
            for(int k=0; k <= lenS; k++){
                lastRow[k] = curRow[k];
            }
        }
        return lastRow[lenS];
    }

    public static void main(String args[]) {
    }
}
