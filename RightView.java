// Time Complexity : O(n) where n is the number of nodes in Binary Tree
// Space Complexity : O(n/2) = O(n) where n is the number of nodes at the maximum breadth
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  None
/* Your code here along with comments explaining your approach: Start with the root. then Use a queue to go level by level deep down. We can use 
BFS And DFS both. We would use BFS in the first case where you insert a root, and then  the left and right child of the node. Similarly, repeat this for 
all the nodes. We need to control the queue here to get all the nodes in the particular level by adjsuting the size pointer of the queue since
we would only fit the nodes in the queue in a particular level at a time. At the end, add the temporary list which is made level wise to the final result. 
Keep the track of the last node on each of the level as that is the right side view of the tree. Put that last node in the resultant list. */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){ return result;}
        Queue<TreeNode> level = new LinkedList<>();                     // Level order traversal
        level.add(root);
        int lastNode = 0;
        while(level.size() > 0){
        int size = level.size();                                        // Adjust the size of the queue
        for(int i =0 ; i < size; i++){
            TreeNode node = level.poll();
            lastNode = node.val;                                        // Keep a track of the last node processed on a particular level
            if(node.left != null){
                level.add(node.left);
            }
            if(node.right != null){
                level.add(node.right);
            }
            }
         result.add(lastNode);                                      // Put the last node in the resultant list
        }
        return result;
    }
}