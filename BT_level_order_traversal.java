// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachclass Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listfinal=new ArrayList<List<Integer>>();
        helper(listfinal,root,0);
        return listfinal;
    }
    private void helper(List<List<Integer>> listfinal,TreeNode root,int height){
        if(root==null){
            return;
        }
        if(height>=listfinal.size()){
            listfinal.add(new LinkedList<Integer>());
        }
        listfinal.get(height).add(root.val);
        helper(listfinal,root.left,height+1);
        helper(listfinal,root.right,height+1);
    }
}