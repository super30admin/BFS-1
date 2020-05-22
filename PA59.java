DFS solution
//Leetcode 199. Binary Tree Right Side View
//Time Complexity : O(n)  // n is the number of nodes in the tree
//Space Complexity: O(n) // size of Stack, where size is equal to height of the tree i.e log(n)
class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        
        res = new ArrayList<>();
        if(root==null){
            return res;
        }
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode n,int level){
        if(n==null){
            return ;
        }
        if(level==res.size()){
            res.add(n.val);
        }
        dfs(n.right,level+1);
        dfs(n.left,level+1);
        return;
        
        
    }
}

========================================
BFS Solution:
//Leetcode 199. Binary Tree Right Side View
//Time Complexity : O(n)  // n is the number of nodes in the tree
//Space Complexity: O(n) // size of Queue, where size is equal to max no nodes at a level in tree i.e n/2

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res= new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len= q.size();
            
            for(int i=0; i<len;i++){
                TreeNode n= q.poll();
                if(i==len-1){
                    res.add(n.val);
                }
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
            }
            
        }
        return res;
        
    }
}
====================================================