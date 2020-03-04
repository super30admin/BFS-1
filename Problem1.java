//BFS-1
//Problem 1
//Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

//BFS
// Time complexity O(n)
// Space complexity O(n) - max number of children
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        //Maintain a queue to process each of the children first before going to the next level
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            //Step 1: Create a temp list to add values at each level
            List<Integer> temp = new ArrayList<>();
            //Step 2: Process children at each level
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                
                //Step 3: All the children of the current node
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            
            result.add(temp);
            
        }
        
        return result;
    }
}

//DFS - using recursion
// Time complexity O(n)
// Space complexity O(h) - max height of the tree
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode node, int level){
        if(node == null)
            return;
        
        if(level == this.result.size()){
            //Initialise a new temp list
           result.add(new ArrayList<>());
        }
        
        result.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}