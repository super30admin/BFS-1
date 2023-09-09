//Using BFS
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Had to lookup queue and its methods


// Your code here along with comments explaining your approach

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
    //Queue to keep track of all the nodes on current level and next level
    Queue<TreeNode> q;
    //Return result
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        q = new LinkedList<>();
        result = new ArrayList<>();
        //Null chack
        if(root == null) return result;

        //Adding first node in the queue and starting bfs from the first node
        q.add(root);
        bfs(root);

        return result;

    }

    public void bfs(TreeNode root){
        //When the node is null, simply return null
        if(root == null) return;

        //We have to run the loop till we process all the nodes on the given level
        int size = q.size();
        //List to store the nodes on the given level
        List<Integer> list = new ArrayList<>();

        //Process the nodes by adding the value to the list and adding nodes on the next level to the queue
        for(int i=0;i<size;i++){
            TreeNode node = q.remove();
            list.add(node.val);
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
//Call BFS on the next level and add the list to the result
        result.add(list);
        bfs(q.peek());
        return;
    }
}


























//Using DFS
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

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
        //List to store result
        List<List<Integer>> result = new ArrayList<>();
        //Null check
        if(root == null) return result;

        //Calling dfs recursive function on root
        dfs(root, 1, result);

        return result;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> result){
        //Base condition
        if(root == null) return;

//Getting the size of result to find if the list exists or not for the given level
        int size = result.size();
//Create and add list if list is not present in result for that level
        if(size<level){
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
//Add the value of node in thelist
        result.get(level-1).add(root.val);
//Call dfs on child nodes
        dfs(root.left, level+1, result);
        dfs(root.right, level+1, result);

        return;
    }
}