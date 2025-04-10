// TC: O(n)
// SC: O(h)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null) return result;

        helper(root, 0);
        return result;
        
    }

    private void helper(TreeNode root, int level) {

        //base case
        if(root == null) return;

        //logic
        if(result.size() == level) {
            result.add(new ArrayList<>());
        } 
        
        helper(root.left, level+1 );

        result.get(level).add(root.val);

        helper(root.right, level+1 );

    }
}