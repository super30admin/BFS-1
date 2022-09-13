// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

//Method 2 - Using DFS(keyword : any) TC: O(n) and SC: O(h) where is the number of nodes in the tree, h is the height

public class LevelOrderTraversalBT {
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
            result = new ArrayList<>();

            //null check
            if(root == null)
                return result;

            dfs(root,0);

            return result;
        }

        private void dfs( TreeNode root, int depth){

            //base case
            if(root == null)
                return;

            //logic
            if(depth == result.size()){
                result.add(new ArrayList<>());
            }

            result.get(depth).add(root.val);

            dfs(root.left, depth+1);
            dfs(root.right,depth +1);
        }
    }



}

//Method 1 - Using BFS(keyword: all) TC: O(n) and SC: O(n) where is the number of nodes in the tree
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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        //null check
        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        //BFS
        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);

                //put children in queue
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }

            result.add(temp);
        }
        return result;
    }
}
*/