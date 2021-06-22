//time complexity: O(n)
//space complexity:O(width)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();//remove the element from queue
                li.add(curr.val);//add it to the list
                if(curr.left!=null) 
                {
                    q.add(curr.left);//add the left subtree
                }//element to the queue
                if(curr.right!=null) 
                {
                    q.add(curr.right);//add the right subtree
                //element to the queue
                }
            }
            res.add(li);
        }
        return res;
    }
}
