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
class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        Queue<TreeNode> tempQueue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
           
            TreeNode curr = queue.remove();
          
                list.add(curr.val);
                if(curr.left!=null)
                    tempQueue.add(curr.left);
                if(curr.right!=null)
                    tempQueue.add(curr.right);

            if(queue.isEmpty()){
                result.add(list);
                list = new ArrayList<Integer>();
                queue=tempQueue;
                tempQueue = new LinkedList<TreeNode>();
            }
        }
        
        return result;*/
        if(root == null) return result;
        helper(root,0);
        return result;
    }
    
    public void helper(TreeNode root,int level){
        if(result.size()==level){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        if(root.left!=null)
            helper(root.left,level+1);
        if(root.right!=null)
            helper(root.right,level+1);
    }
}
