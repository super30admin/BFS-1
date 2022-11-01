class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> tq;
        q.add(root);
        if(root== null){
            return result;
        }
        while(!q.isEmpty()){
            tq = new LinkedList<TreeNode>();
            ans = new ArrayList<>();
            while(!q.isEmpty()){
                TreeNode s = q.poll();
                ans.add(s.val);
                if(s.left!=null){
                tq.add(s.left);}
                if(s.right!=null){
                tq.add(s.right);}
            }
            q = tq;
            result.add(ans);
        }
        return result;
    }
}
//tc=O(n)
//sc=O(n)
