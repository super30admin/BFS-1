//approach- bfs
//go level by level 
//create local list for every level and add values at every level
// after for loop add local list to main result
// if check to avoid null list added to the main result. 
//TC - O(n)
//SC -O(n) - queue
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
    List<List<Integer>> result ;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        result = new ArrayList<>();
        if(root  == null ) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                if(curr != null)
                {
                    list.add(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                    // System.out.println("->  " + list);
                }
                
            }
            if(list.size()>0)
                result.add(list);
        }
        return result;
    }
}