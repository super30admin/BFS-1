Executed in Leetcode -yes
time complexity-o(n)
space complexity-o(h)

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
           //base case
        if(root==null) return new ArrayList<Integer>();
        //logic
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        List<Integer> rslts = new ArrayList<Integer>();
        while(q.size()>0){
            int size=q.size();
            Integer levelRslt =-1;
            for(int i=0; i< size;i++){
                TreeNode temp = q.poll();
                levelRslt =temp.val;
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            rslts.add(levelRslt);
            
        }
        return rslts; 
    }
}

