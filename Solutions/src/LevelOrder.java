// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q =  new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root ==  null){
            return result;

        }

        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> sublist =  new LinkedList<Integer>();
            for(int i = 0;i<level;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                sublist.add(q.poll().val);
            }
            result.add(sublist);
        }
        return result;
    }
}

