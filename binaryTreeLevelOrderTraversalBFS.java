//bfs approach
// TC O(N) SC O(N/2) ~ O(N) because at any given point queue consits only of elements at that p[articular level
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                li.add(cur.val);
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
            result.add(li);
        }
        return result;
    }
}