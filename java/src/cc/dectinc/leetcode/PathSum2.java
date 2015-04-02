package cc.dectinc.leetcode;

import cc.dectinc.leetcode.structs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dectinc (i@dectinc.cc)
 * @date 2015-04-02 14:45 PM
 */
public class PathSum2 {
    public PathSum2() {
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        findPath(root, sum, new ArrayList<Integer>());
        return result;
    }

    public void findPath(TreeNode root, int sum, List<Integer> curPath) {
        if (root == null) {
            return;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            List<Integer> aResult = new ArrayList<Integer>(curPath);
            aResult.add(sum);
            result.add(aResult);
            return;
        }
        curPath.add(root.val);
        findPath(root.left, sum - root.val, curPath);
        findPath(root.right, sum - root.val, curPath);
        curPath.remove(curPath.size()-1);
    }

    public static void main(String args[]) {
        PathSum2 sol = new PathSum2();
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(-2);
//        root.right = new TreeNode(4);
//        root.left.right = new TreeNode(1);
        System.out.println(sol.pathSum(root, -4));
    }
}
