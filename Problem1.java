Time Complexity: O(n)
Space Complexity: O(n)
Ran successfully on leetcode?: yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) {
            return new ArrayList(new ArrayList());
        } else {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            bfs(queue);
            return result;
        }
    }
    
    private void bfs(Queue<TreeNode> queue){
        int size = queue.size();
        if(size == 0) return;
        else{
            List<Integer> temp = new ArrayList<>();
            while(size > 0){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                temp.add(queue.poll().val);
                size--;
            }
            result.add(temp);
            bfs(queue);
        }
    }
}
