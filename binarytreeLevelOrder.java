//Using BFS
//time complexity: O(n) where n is the total number of nodes in the tree
//space complexity: O(n/2) where n the number of all leaf nodes(which are null;children of actual leaf nodes)
//approach: we are using a queue to store the nodes of a tree, we remove element from queue and add it  to list(marking it as processed) and add its children to the queue(waiting to be processed). we maintain a size variable in a queue so that we know which nodes are of which level in the tree.

//Using DFS
//time complexity: O(n)
//space complexity: O(n/2) where n the number of all leaf nodes(which are null;children of actual leaf nodes)
//approach: we maintain a result list of list on integers which has a list for each levels in the tree
// if the size of the list is equal to the level, it means that we need a new level to be added to result
// else it means that list for that level is already present and that we just need to add the node.val to this list
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {   List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            result.add(list);
        }
        return result;
        
    }
}
**/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        dfs(root,0);  //0 refers to the level of the tree where our current root is
        return result;
    }
    public void dfs(TreeNode root,int level)
    {   if(root==null) return;
        if(result.size()==level)
        {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}