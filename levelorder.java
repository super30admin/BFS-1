//time complexity: O(n)
//space complexity: O(h)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        this.result=new ArrayList<>();
        helper(root,0);
        return result;
        
    }
    public void helper(TreeNode root,int height)
    {
        if(root==null) return;
        if(result.size()==height)
        {
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);
        helper(root.left,height+1);
        helper(root.right,height+1);
    }
}


//time complexity: O(n)
//space complexity: O(n/2)

List<List<Integer>> result =new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> t=new ArrayList<>();

            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                t.add(temp.val);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            result.add(t);
        }
        return result;