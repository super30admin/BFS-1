//TimeComplexity: O(n)
//SpaceComplexity: O(n)
//Leetcode: Yes

//Traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return lists;
        
        //Traversing BFS using queues
        int layer = 0; // layer increments 
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); // Adding the visited node - initially
        
        while(!q.isEmpty()){
            
            lists.add(new ArrayList<Integer>()); // At the new layer
            
            int n = q.size();
            for(int i =0; i<n;i++){
                //Remove the visited node and go to the adjacent nodes to propagate
                
                TreeNode node = q.remove();
                
                //Add the removed node in the layer
                
                lists.get(layer).add(node.val);
                
                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            layer++;
        }
        return lists;
        
    }
}