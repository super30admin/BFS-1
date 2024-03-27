
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
//Approach 1 - BFS
// TC: O(n) as we are traversing all the nodes
// SC: O(n) which will be n/2 because at max we can have n/2 nodes in queue for the leaf level if tree is fully balanced
// Add all children to queue, create sublists in result as per the size of the queue and iterate over the size to add all values
// Add left and right children to the queue and repeat
// For each level create a new list and keep adding it to the final result
class Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left!=null){
                q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                } 
            result.add(li);
        }
        return result;
    }
}

//Approach 2: Using DFS/Recursion
// Use helper function to pass level as local argument and call the function recursively on left and right child
// at each node check if a new list is to be created in result, for same level the values will go into the same sublist
//return result
//TC: O(n)
//SC: O(h) where h is the size of recursive stack which is the height of the tree
class Level_Order_Traversal {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if ( root == null) return result;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(root.left, level +1);
        helper(root.right, level+1);
    }
}