//TC: O(N) n is nodes in my tree
//SC: O(N) same
//ran in leetcode? yes
//any problem? no

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> lvl = new ArrayList<>();
            int l = q.size();
            for(int i = 0; i<l; i++){
                TreeNode n = q.poll();
                if(n != null){
                    lvl.add(n.val);
                    q.add(n.left);
                    q.add(n.right);
                }
            }
            if(!lvl.isEmpty())
                res.add(lvl);

        }
        return res;
    }
}
