// Level Order with BFS 

// Time Complexity : O(n) 
// Space Complexity : O(n), when at leaf level, there will be n/2 elements in the queue
// Did this code successfully run on Leetcode : yes

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
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int size;

        while(!q.isEmpty()){
            size = q.size(); // to keep a check of the level 
            ArrayList<Integer> li = new ArrayList<>();
            //processing of the level
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                
                //add children if they exist
                if(curr.left != null){
                    q.add(curr.left);
                } 
                if(curr.right != null){
                    q.add(curr.right);
                } 
            }
            result.add(li);
        }

        return result;

    }
}

// Level order with dfs

// Time Complexity : O(n) 
// Space Complexity : O(h), recursion stack will have at max height of tree elements
// Did this code successfully run on Leetcode : yes

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
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return;

        // if the size of the result is same as level, we add a list for that level
        if(level == result.size()){
            result.add(new ArrayList<Integer>());
        }
        //add value to the corresponding list of that level
        result.get(level).add(root.val);
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);

    }
}