// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        compute(ans,root,0);
        return ans;
    }
    
    public void compute(List<List<Integer>> ans,TreeNode curr,int level)
    {
        if(curr==null) return;
        
        if(ans.size()==level) 
            ans.add(new ArrayList<Integer>());
        
        ans.get(level).add(curr.val);
        
        compute(ans,curr.left,level+1);
        compute(ans,curr.right,level+1);
    }
}
