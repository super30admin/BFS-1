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
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : nopes

/*BFS solution
class SolutionOne {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> temp;
    HashMap<TreeNode,Integer> map;
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root==null)
            return result;

        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            temp = new ArrayList<Integer>();

            for(int i=0;i<size;i++)
            {

                TreeNode curr=q.poll();
                temp.add(curr.val);

                if(curr.left!=null)
                    q.add(curr.left);

                if(curr.right!=null)
                    q.add(curr.right);
            }
            result.add(temp);


        }

        return result;

    }

}*/

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
class SolutionOne {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> temp;
    HashMap<TreeNode,Integer> map;
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root==null)
            return result;

        dfs(root,0);

        return result;
    }
    public void dfs(TreeNode root,int level)
    {
        if(root==null)
            return;

        if(level==result.size())
        {
            result.add(new ArrayList());
        }

        result.get(level).add(root.val);

        dfs(root.left,level+1);

        dfs(root.right,level+1);
    }

}