// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode troot=q.poll();
                temp.add(troot.val);
                if(troot.left!=null){
                    q.add(troot.left);
                }
                if(troot.right!=null){
                    q.add(troot.right);
                }
            }
            result.add(temp);
        }
    return result;
    }
}