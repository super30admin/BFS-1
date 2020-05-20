//level order traversal
//Auxillary space o(1), without it, space is o(h)
//time o(n) 
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        if(root == null)
            return res;
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int level){
        //base case
        if(root == null)
            return;
        //logic
        if(level == res.size()){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}