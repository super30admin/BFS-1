//199 Binary Tree Right Side View Medium.java
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

//5:48
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //edge case
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            
            //process current level
            int levelSize = q.size();
            //processing nodes in the level
            for (int i = 0; i < levelSize; ++i){
                
                TreeNode currentNode = q.poll();
                
                //check left subtree
                if( currentNode.left != null){
                    //add to queue
                    q.add(currentNode.left);
                }
                
                //check right subtree
                if( currentNode.right != null){
                    //add to queue
                    q.add(currentNode.right);
                }
                
                //is last node of the level?
                if(i == (levelSize-1)){
                    //it is last node 
                    //add to result
                    result.add(currentNode.val);
                }
              //  System.out.println(i);
                
            }
        }
        return result;
    }
}