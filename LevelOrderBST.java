//Time complexity : O(n)
//Space complexity : O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int  size  = q.size();
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                ans.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            result.add(ans);
        }
        return result;
    }
}