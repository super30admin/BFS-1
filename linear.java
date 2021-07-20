//time complexity :O(N)
//Space complexity :O(1)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        
        Queue<TreeNode> tree = new LinkedList<>();
        
        tree.add(root);
        while(!tree.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int sz =tree.size();
            for(int i =0;i<sz;i++)
            {
              TreeNode curr = tree.poll();
                if(curr.left!=null)tree.add(curr.left);
                if(curr.right!=null)tree.add(curr.right);
                temp.add(curr.val);
            }
            result.add(temp);
        }
        return result;
    }
}