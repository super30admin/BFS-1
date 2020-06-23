// Time Complexity: O(n) as we traverse through all nodes
// Space Complexity: O(n) which is max elements in the queue
// Do level order traversal and put the last one of each level into the result list.
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) return res;
        q.offer(root);
        while(!q.isEmpty()) {
            int level = q.size();
            for(int i=0;i<level;i++) {
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                if(i==level-1) res.add(q.poll().val);
                else q.poll();
            }
        }
        return res;
    }
}