//102 Binary Tree Level Order Traversal Medium.java
//Time Complexity: O(n)
//Space Complexity: O(n)


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        
        List<List<Integer>> result = new ArrayList<>();
        //edge case
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            //process queue one level at time
            int levelSize = q.size();
            List<Integer> temp = new ArrayList<>();
            
            //process all the nodes in current level
            for (int i = 0; i < levelSize; ++i){
                //process current Node
                TreeNode currentNode = q.poll();
                temp.add(currentNode.val);
                
                //check left subtree
                if(currentNode.left != null){
                    q.add(currentNode.left);
                } 
                
                //check right subtree                
                if(currentNode.right != null){
                    q.add(currentNode.right);
                } 
            }
        //add currentLevel to result
        result.add(temp);
        }
        return result;
    }
}