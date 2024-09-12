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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null ) return result;
       
        Queue<TreeNode> q = new LinkedList<>();
        int size = 0; //size of queue at each level to distinguish between levels
       
        q.add(root); // independent element added important start
       
        while(!q.isEmpty()){
            size = q.size();
            List<Integer> temp = new ArrayList<>();
            //Level order processing
            for(int i = 0; i < size ; i++){
                TreeNode curr =  q.poll();
                temp.add(curr.val);  //collect at each level in separate lists
                //if curr has left child
                if(curr.left != null ) q.add(curr.left);
                if(curr.right != null ) q.add(curr.right);
            }
            result.add(temp);
        }
        return result;
    }
}

/*
Time Complexity: traversing all the elements hence O(n)
Space Complexity: BFS is calculated based on width so at max at any level it is  2 to the power H (height) . At leaf nodes 2 to the power n approximates to n/2 or say O(w/2) where w is the width. Because it is at leaf we have max elements possible .Therefore asymtotic space complexity is O(w)

*/
