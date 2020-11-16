//Time Complexity: O(n) | Since we are traversing the entire tree
//Space Complexity: O(n)
//Program ran successfully
/*
    Algorithm: 1. The left amd right child of the parent nodes(if not null) are added to a queue after the parent node is processed
               2. A size variable is maintained at each iteration to maintain levels
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode polled = q.poll();
                level.add(polled.val);
                if(polled.left != null) q.add(polled.left);
                if(polled.right != null) q.add(polled.right);
            }
            result.add(level);
        }
        return result;
    }
}
