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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
       
        if(root == null ) return result;
        int size = 0;    
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); //independent node
       
        while(!q.isEmpty()){
           
            size = q.size();
            int last = -1;
            // start level order traversing
            for( int i = 0 ;i < size ; i++){
                TreeNode curr =  q.poll();
                last =  curr.val; //right most element
                if(curr.left != null ) q.add(curr.left);
                if(curr.right != null ) q.add(curr.right);
            }
              // end level order traversing
            result.add(last);
        }
        return result;
    }
}

/*
BFS approach
Time complexity:O(n) because traversing all the nodes
Space complexity:It is O(H/2) at the leaf which is the width since 2^H (h is height) approximates to H/2
which asymtotically can be said O(H)
*/