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
// Time 0(n)
// space constant
// BFS
/*class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
        {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> list =new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                list.add(curr.val);
                if(curr.left!=null)
                {
                  q.add(curr.left);
                }
                if(curr.right!=null)
                {
                  q.add(curr.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}*/

//DFS
class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
        {
            return new ArrayList<>();
        }
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int lvl)
    {
        if(root==null)
        {
            return;
        }
        if(lvl==result.size())
        {
            result.add(new ArrayList<>());
        }
        result.get(lvl).add(root.val);
        dfs(root.left,lvl+1);
        dfs(root.right,lvl+1);
    }
}



