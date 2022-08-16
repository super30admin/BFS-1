// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//102. Binary Tree Level Order Traversal (Medium) - https://leetcode.com/problems/binary-tree-level-order-traversal/
class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
    	// Time Complexity : O(n) where n = number of elements of the tree, Space Complexity : O(n) where n = width of the tree
//         List<List<Integer>> result = new ArrayList<>();
        
//         if (root == null) return result;
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             List<Integer> temp = new ArrayList<>();
            
//             for (int i = 0; i < size; i++) {
//                 TreeNode curr = queue.poll();
//                 temp.add(curr.val);
                
//                 if (curr.left != null) queue.add(curr.left);
//                 if (curr.right != null) queue.add(curr.right);
//             }
            
//             result.add(temp);
//         }
        
//         return result;
    	
    	// Time Complexity: O(n), Space Complexity : O(h) where h = height of the tree
//        result = new ArrayList<>();
//        
//        if (root == null) return result;
//        
//        dfs(root, 0);
//        return result;
//    }
//    
//    private void dfs(TreeNode root, int level) {
//        // base
//        if (root == null) return;
//        
//        // logic
//        if (level == result.size()) {
//            result.add(new ArrayList<>());
//        }
//        
//        result.get(level).add(root.val);
//        
//        dfs(root.left, level + 1);
//        dfs(root.right, level + 1);
    	
    	// Time Complexity : O(n) where n = number of elements of the tree, Space Complexity : O(n) where n = width of the tree
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;
        
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();
        
        nodeStack.push(root);
        levelStack.push(0);
        
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int level = levelStack.pop();
            
            if (level == result.size()) {
                result.add(new ArrayList<>());
            }
            
            result.get(level).add(curr.val);
            
            if (curr.right != null) {
                nodeStack.push(curr.right);
                levelStack.push(level + 1);
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
                levelStack.push(level + 1);
            }
        }
        
        return result;
    }
}