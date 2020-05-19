// Time Complexity : O(n) where n is the number of nodes in Binary Tree
// Space Complexity : O(n/2) = O(n) where n is the number of nodes at the maximum breadth
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  None
/* Your code here along with comments explaining your approach: Start with the root. then Use a queue to go level by level deep down. We can use 
BFS And DFS both. We would use BFS in the first case where you insert a root, and then  the left and right child of the node. Similarly, repeat this for 
all the nodes. We need to control the queue here to get all the nodes in the particular level by adjsuting the size pointer of the queue since
we would only fit the nodes in the queue in a particular level at a time. At the end, add the temporary list which is made level wise to the final result. 
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){return result;}
        Queue<TreeNode> queue = new LinkedList<>();                         // Queue for BFS
        queue.add(root);
        while(queue.size()>0){
            List<Integer> temp = new ArrayList<>();
            int n = queue.size();
            for(int i =0; i < n; i++){                                  // Controlling the size pointer
            TreeNode q = queue.poll();
            temp.add(q.val);                                            // Add the nodes in a particular level by fetching all nodes from the queue at a time
            if(q.left != null){
                queue.add(q.left);
            }
            if(q.right != null){
                queue.add(q.right);
            }
            }
            result.add(temp);                                   // Add the temp list to the final answer
        }
        return result;
    }

    /* DFS

    class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<List<Integer>>();
        if(root == null){return result;}  
        dfs(root, 0);                                                   // Using DFS with Stack and using the level starting from 0
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root == null){return;}
        if(result.size() == level){                                     // The result's size is equal to the level, 
            result.add(new ArrayList<Integer>());
        } 
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);            
    }
    */
}