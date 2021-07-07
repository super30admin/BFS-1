//Time Complexity:O(n)
//Space complexity:O(h)

//DEPTH FIRST SEARCH
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result=new ArrayList();
        if(root==null){
            return result;
        }
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int level){
        if(root==null){
            return;
        }
        if(level==result.size()){
            result.add(root.val);
        }
        helper(root.right,level+1);
        helper(root.left,level+1);
    }
}