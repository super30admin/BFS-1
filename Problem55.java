Executed in Leet Code- Yes
Time Complexity-o(n)
Space complexity -o(n)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //base case
        if(root==null) return new ArrayList<List<Integer>>();
        //logic
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        List<List<Integer>> rslts = new ArrayList<List<Integer>>();
        while(q.size()>0){
            int size=q.size();
            List<Integer> levelRslts = new ArrayList<Integer>();
            for(int i=0; i< size;i++){
                TreeNode temp = q.poll();
                levelRslts.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            rslts.add(levelRslts);
            
        }
        return rslts;
    }
}
