// Time Complexity : O(n) //n nodes that we are traversing
// Space Complexity : O(n) ~ O(n/2) : At leaf, we have n/2 nodes in queue which is O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yeah, condition check issues.

//Take queue and keep adding nodes.
//Maintain size of queue for knowing at each node how many TreeNodes are there as this is not balanced binary tree
//While polling from queue, add its left and right node and continue this process till the end.

//This is BFS traversal of tree.

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
class BTLevelOrderTravBFS {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) // Add an empty list to listOfLists
            return list;

        queue.add(root);
        int size = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            //processing of level
            while(size !=0){
                TreeNode node = queue.poll(); //Better to take variable here.          
                subList.add(node.val);

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }

                size--;
            }
            list.add(subList); //Add Level List in to Result list.
        }

        return list;
        
    }
}