// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BT_level_order_traversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderUsingBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size(); //to know how many nodes to process at this level
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            result.add(temp);
        }
        return result;
    }

    List<List<Integer>> result;
    public List<List<Integer>> levelOrderUsingDFS(TreeNode root) {
        result = new ArrayList<>();
        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic

        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        dfs(root.left, level + 1);
        //st.pop() happens internally
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {

        TreeNode t15 = new TreeNode(15, null, null);
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t9 = new TreeNode(9, null, null);
        TreeNode t3 = new TreeNode(3, t9, t20);

        System.out.println("BT_level_order_traversal: " + new BT_level_order_traversal().levelOrderUsingBFS(t3));
//        System.out.println("Can all the courses be completed? : " + canFinish(2, new int[][]{{1,0}, {0,1}}));
    }

}
