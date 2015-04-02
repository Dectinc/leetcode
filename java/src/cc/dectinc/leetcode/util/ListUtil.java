package cc.dectinc.leetcode.util;

import java.util.List;

/**
 * @author Dectinc (i@dectinc.cc)
 * @date 2015-04-02 16:57 PM
 */
public class ListUtil {
    public ListUtil() {
    }

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

    public static void main(String args[]) {
    }
}
