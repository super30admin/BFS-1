//Time Complexity: O(N) Space: O(2^(levels-1) || breadth of the tree)

//BFS - Top - bottom approach - FIFO approach
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        int key = 0;
        if(root != null)
            q.add(root);
        int levelSize = q.size();
        int levelItems = 0;
        // starting from root node
        while(levelItems < levelSize) {
            TreeNode dequeued = q.poll();
            if(key != result.size() -1)
                result.add(new ArrayList<>());
            result.get(key).add(dequeued.val);
            // processing the left right of curr node pulled out of queue
            if(dequeued.left != null)
                q.add(dequeued.left);
            if(dequeued.right != null)
                q.add(dequeued.right);
            // when we reach the last node at every level,
            // we reset the counters and traversal size to process the next level
            if(levelItems == levelSize-1) {
                key++;
                levelItems = 0;
                levelSize = q.size();
            } else
                // when on current level
                levelItems++;
        }
        return result;
    }

}

//DFS - LIFO approach
//Time Complexity: O(N) | Space: O(Height of the tree) - callstack

class Solution {
    Map<Integer, List<Integer>> levels = new HashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return new ArrayList<>(levels.values());
    }
    private void helper(TreeNode root, int currSum) {
        if(root == null) return;
        helper(root.left, currSum+1);
        helper(root.right, currSum+1);
        if(!levels.containsKey(currSum))
            levels.put(currSum, new ArrayList<>());

        levels.get(currSum).add(root.val);
    }
}