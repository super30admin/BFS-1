import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Approach: DFS with visiting root.right before root.left
//1. Traverse through all the nodes in the right of the tree with DFS, adding it to the result. 
public class Binary_Tree_Right_Side_view {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level)
    {
        if(root == null)
            return;
        if(level == result.size())
            result.add(root.val);
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}
//Time Complexity : O(h) where h is the height of the tree, since we are looking only for nodes visible from right side. 
//Space Complexity : O(n) for the recursive stack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :


//Approach: DFS 
//1. Traverse through all the nodes in the tree with DFS, adding it to the result. But when we see a new node in the same level, 
//we will overwrite the previous node to get only the nodes on the right side. 
class Solution1 {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level)
    {
        if(root == null)
            return;
        
        if(level == result.size())
        {
            result.add(root.val);
        }
        result.set(level, root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
//Time Complexity : O(h)  
//Space Complexity : O(n) for the recursive stack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

//Approach: BFS
//1. Traverse through all the nodes in the tree with BFS, find the last node in each level and add it to the result
class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int level = queue.size();
            for(int i=0;i<level;i++)
            {
                TreeNode node = queue.poll();
                if(i== level-1)
                    result.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return result;
    }
}
//Time Complexity : O(n) 
//Space Complexity : O(n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :