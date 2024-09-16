//Problem 3
//Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

// using BFS time complexity O(n) and space complexity O(n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            
            int last = 0;
            for(int i = 0; i < size; i++){
                TreeNode currNode = q.poll();
                last = currNode.val;
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
 
         }
            
            result.add(last);
            
        }
        
        return result;
    }
}

// using DFS time complexity O(n) and space complexity O(height)
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        if(root == null)
            return;
        if(result.size() == level){
            result.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}