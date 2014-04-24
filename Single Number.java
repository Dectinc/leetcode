public class Solution {
    public int singleNumber(int[] A) {
        int len = A.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ A[i];
        }
        
        return res;
    }
}