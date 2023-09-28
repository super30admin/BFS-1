// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Using BFS, maintain a queue and whenever the element in the loop equals last element form right i.e size-1 then add it to the list
 * Check the current element's left and right
 */
import java.util.*;
class SolutionBFS {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i< size;i++){
                TreeNode curr = q.poll();
                if(i==size-1)
                    result.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        return result;
    }
}
/*
 * DFS-Stack
 * Check if level is equal to size of the result list. If yes, add to result
 */
class SolutionDFS {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)   
            return new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    void dfs(TreeNode root, int lvl){
        if(root == null)    
            return;
        if(lvl == result.size()){
            result.add(root.val);
        }
        dfs(root.right, lvl+1);
        dfs(root.left, lvl+1);
    }
}