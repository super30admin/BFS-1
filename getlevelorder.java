/*
Time complexity : O(N) since all the elements are traversed once.
Space complexity : O(N) Using ArrayList to store the results, also for recursion there will be O(H) stack space

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
class Solution {
    List<List<Integer>> resultlist;
    public List<List<Integer>> levelOrder(TreeNode root) {
        resultlist = new ArrayList<>();
        //getlevelorder_iterative(root);
        getlevelorder(root,0);
        return resultlist;
    }
    public void getlevelorder(TreeNode root,int depth)
    {
        if(root==null)
            return;
        List<Integer> list;
        if(resultlist.size()==depth)
        {
            list = new ArrayList<>();
            resultlist.add(list);
        }
        else
            list=resultlist.get(depth);
        list.add(root.val);
        if(root.left!=null)
            getlevelorder(root.left,depth+1);
        if(root.right!=null)
            getlevelorder(root.right,depth+1);
    }
    public void getlevelorder_iterative(TreeNode root)
    {
        if(root==null)
            return;
        Queue<TreeNode> queue1=new LinkedList<>();
        queue1.add(root);
        while(!queue1.isEmpty())
        {
            List<Integer> currlist=new ArrayList<>();
            int size=queue1.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=queue1.remove();
                currlist.add(temp.val);
                if(temp.left!=null)
                    queue1.add(temp.left);
                if(temp.right!=null)
                    queue1.add(temp.right);
            }
            resultlist.add(currlist);
        }
    }
}
