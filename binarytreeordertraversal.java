/*
Time Complexity: O(N)
Space Complexity: O(N)
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                TreeNode temp = q.poll();
                list.add(temp.val);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            res.add(list);
        }
        return res;
    }
}