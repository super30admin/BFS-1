// Time-complexity:O(n)

// Space complexity:O(max(breadth))

// Ran succesfully on leetcode:yes

// Solution with approach:

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

        List<List<Integer>> out= new ArrayList<List<Integer>>();

        if(root==null) return out;

        

        Queue<TreeNode> q = new LinkedList<>();//Using BFS approach to store in Queue and storing the size at each level

        q.add(root);

       

        while(!q.isEmpty())

        {

            int size=q.size();

            List<Integer> in= new ArrayList<>();

            for(int i=0;i<size;i++)//For each node at particular level

            {

                TreeNode n= q.poll();

                in.add(n.val);

                if(n.left!=null) q.add(n.left);

                if(n.right!=null) q.add(n.right);

            }

            out.add(new ArrayList(in));

            

        }

        

        return out;

            

    }

}
