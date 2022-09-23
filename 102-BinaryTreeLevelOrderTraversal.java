//Approach-1: Using the size variable
//Overall Time Complexity: O(N) -> Number of nodes in the tree
//Overall Space Complexity: O(N) -> At max queue could hold the elements in the leaf level
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            List<Integer> temp = new ArrayList<Integer>();
            
            for(int i = 0; i < size; i++){
                TreeNode tempNode = q.poll();
                temp.add(tempNode.val);
                
                if(tempNode.left != null) q.add(tempNode.left);
                if(tempNode.right != null) q.add(tempNode.right);
            }
            
            res.add(temp);
        
        }
        
        return res;
    }
}


//Approach-2: Using Recursion or the DFS approach
//Overall Time Complexity: O(N) -> Number of nodes in the tree
//Overall Space Complexity: O(H) -> Height of the recursion stack
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return res;
        dfs(root, 0);
        return res; 
    }
    
    private void dfs(TreeNode node, int level){
        if(node == null) return;
        
        if(res.size() == level) res.add(new ArrayList<>());
        
        res.get(level).add(node.val); 
        
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
        
        return;
    }
}