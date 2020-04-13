// Time Complexity: O(n)
// Space Complexity: O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Problem1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> listOfList = new ArrayList<>(); 
        if (root != null){
            q.offer(root);
        }
        TreeNode curr;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> levels = new ArrayList<>();
            for (int i = 0; i<size; ++i ){
                curr = q.poll();
                levels.add(curr.val);
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            listOfList.add(levels);
        }
        return listOfList;
    }
}
