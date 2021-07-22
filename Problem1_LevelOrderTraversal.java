// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    //BFS using Queue 
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root==null)
            return new ArrayList<>();
        
        List<List<Integer>> result=new ArrayList<>();
        
        Queue<TreeNode> queue=new LinkedList<>();
          queue.offer(root);
          
        
        while(!queue.isEmpty())
        {
            int queueSize=queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0;i<queueSize;i++)
            {
                TreeNode currNode=queue.poll();
                currLevel.add(currNode.val);
                if(currNode.left!=null)
                    queue.add(currNode.left);
                if(currNode.right!=null)
                    queue.add(currNode.right);
            }
            result.add(currLevel);
        }
        return result;
    }
    /*
    // using dfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root==null)
            return new ArrayList<>();
        
        List<List<Integer>> result=new ArrayList<>();
        
        dfs(root,0,result);
        return result;
          
    }
    
    private void dfs(TreeNode root,int depth, List<List<Integer>> result)
    {
        if(root==null)
            return;
        if(result.size()==depth)
            result.add(new ArrayList<>());
        
        result.get(depth).add(root.val);
        
        dfs(root.left,depth+1,result);
        dfs(root.right,depth+1,result);
    }
    */
}