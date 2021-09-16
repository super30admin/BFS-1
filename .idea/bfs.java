*         this.left = left;
        *         this.right = right;
        *     }
        * }
        */
//time o(n)
//space o(n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode cur = q.poll();
                if(i == size-1) {
                    res.add(cur.val);
                }
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        return res;
    }
}