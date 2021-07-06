//Leetcode 102. Binary Tree Level Order Traversal
//BFS solution
//Time Complexity : O(n)  // n is the number of nodes in the tree
//Space Complexity: O(n) //size of Queue, where size is equal to max no nodes at a level in tree i.e n/2
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        
            Queue<TreeNode> q= new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int s=q.size();
                List<Integer> ls = new ArrayList<>();
                for(int i=0; i<s;i++){
                    TreeNode t= q.poll();
                    ls.add(t.val);
                    if(t.left!=null) q.offer(t.left);
                    if(t.right!=null) q.offer(t.right);
                }
                res.add(ls);
            }
        return res;
    }
}


======================================================================
//Leetcode 102. Binary Tree Level Order Traversal
//DFS solution:
//Time Complexity : O(n)  // n is the number of nodes in the tree
//Space Complexity: O(n) // size of Stack, where size is equal to height of the tree i.e log(n)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<List<Integer>>();
        if(root==null) return res;                   
        dfs(root,0);
        return res;       
    } 
    private void dfs(TreeNode root, int level){
        if(root==null){
            return ;
        }        
        if(res.size()==level){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);      
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        
    }
}
==========================================================================
