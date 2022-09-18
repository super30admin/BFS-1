// Time Complexity : O(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * For the first approach, bfs is used. Where at each level. nodes are added to a Queue , and then when popping the root node its
 * children are added to the Queue. This is a level order traversal using Bfs. A size variable is maitained to store
 * the level of tree at each point.
 */


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
class Problem1{
    public List<List<Integer>> levelOrder(TreeNode root) {
        //for level order traversal we will use the bfs approach
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            //creating a size variable for level

            int size = q.size();

            //taking a temp list
            List<Integer> temp = new ArrayList<>();

            for(int i=0; i<size; i++)
            {

                TreeNode curr = q.poll();
                temp.add(curr.val);

                //add childern of curr to queue
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }

            result.add(temp);
        }
        return result;

    }
}

//dfs approach
/*
class Solution {
    //taking result as global
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return result;

        dfs(root, 0);

        return result;
    }

    //dfs function
    private void dfs(TreeNode root, int depth){

        //base
        if(root==null) return;


        //logic
        if(depth == result.size()){

            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }
        //else get the list at that depth and add value to it
        result.get(depth).add(root.val);

        dfs(root.left, depth+1);

        dfs(root.right, depth+1);

    }
}


 */