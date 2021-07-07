Time Complexity: O(n)
Space Complexity: O(h). Recursive stack space.
Ran successfully on leetcode?: yes

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        bfsHelper(root, 0);
        return result;
    }
    
    private void bfsHelper(TreeNode node, int level){
        if(node == null) return;
        
        if(level == result.size()) result.add(node.val);
        if(node.right != null) bfsHelper(node.right, level + 1);
        if(node.left != null) bfsHelper(node.left, level + 1);
    }
}
