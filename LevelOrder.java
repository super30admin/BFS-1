// Using DFS
//Time Complexity: O(n)
//Space Complexity: O(n)=> recursive stack size will be O(height of tree). In worst case it will be O(n) when tree is linear
//Leetcode: 102. Binary Tree Level Order Traversal
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res=new ArrayList<>();
        int depth=0;
        dfs(root,depth);
        return res;
    }
    
    public void dfs(TreeNode node, int depth)
    {
        if(node==null)
            return;
        if(res.size()==depth)
        {
           ArrayList<Integer> list =new ArrayList<>();
            res.add(list);
        }
        res.get(depth).add(node.val);
        depth++;
        dfs(node.left,depth);
        dfs(node.right,depth);
    }
}

/*
//Using BFS
//Time Complexity: O(n)
//Space Complexity: O(n)=> For using queue.
//Leetcode: 102. Binary Tree Level Order Traversal

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        
        if(root==null)
            return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int len=0;
        TreeNode node;
        while(!q.isEmpty())
        {
            len=q.size();
            ArrayList<Integer> level=new ArrayList<>();
            for(int i=0;i<len;i++)
            {
                node=q.poll();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                level.add(node.val);
            }
            res.add(level);
            
            
        }
        
        return res;
        
        
    }
}

*/