package S30.BFS_1;

import java.util.ArrayList;
import java.util.LinkedList;


/*BFS Solution
Time Complexity : O(n) - touching every node
Space Complexity : O(n/2) - max queue size at last level
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

/*DFS Solution
Time Complexity : Put: O(n) - touching every node
Space Complexity : O(h) - height of stackframe/tree / O(n) if the tree is skewed
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.List;
import java.util.Queue;



public class BinaryTreeLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                res.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            result.add(res);
        }

        return result;
    }


    //Level Order traversal using depth first search
    public List<List<Integer>> levelOrderDFS(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,result,0);
        return result;
    }

    public void dfs(TreeNode root, List<List<Integer>> result, int level){

        if(root == null) return;
        if(result.size() == level){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        dfs(root.left,result,level+1);
        dfs(root.right,result,level+1);

    }

    //Iterative DFS Traversal
    public List<List<Integer>> levelOrderIterativeDFS(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,result,0);
        return result;
    }
}
