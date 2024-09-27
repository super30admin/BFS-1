// Time Complexity : O(V)
// Space Complexity : O(n) n is max diameter or width of all levels
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)  return new ArrayList<>();
        
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null){
                    q.add(temp.left);
                }
                 if(temp.right!=null){
                    q.add(temp.right);
                }
                if(i==s-1){
                    res.add(temp.val);
                }
            }
        }
        return res;
    }
}