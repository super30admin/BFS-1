// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Maintain a queue and insert every node and while removing the node from queue, check for the left and right node of that root
 */
import java.util.*;
class SolutionBFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i< size;i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
             result.add(temp);
        }
        return result;
    }
}
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class SolutionDFS {
    List<List<Integer>> result; 
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    void dfs(TreeNode root, int lvl){
        if(root == null)
            return;
        if(lvl == result.size()){
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.add(temp);
        }
        else{
            result.get(lvl).add(root.val);
        }
        dfs(root.left, lvl+1);
        dfs(root.right, lvl+1);
    }
}