// Solution -1

// TimeComplexity: O(n) where n is number of nodes
// SpaceComplexity: O(h) where h is height of the tree. 
// Explantion:  I perform a DFS traversal while keeping track of the current depth (level). When visiting a node, if this is the first time reaching that level,
//  I create a new list and add it to the result; otherwise, I append the value to the existing list for that level.
//  I then recursively process the left and right children with level + 1, which ensures all nodes are grouped by depth in level-order form.



class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> result){
        // base
        if(root == null) return;

        // logic
        List<Integer> inter;
        if(level == result.size()) {
            inter = new ArrayList<>();
            result.add(inter);
        } else {
            inter = result.get(level);
        }

        inter.add(root.val);
        
        // children

        helper(root.left, level+1, result);
        helper(root.right, level+1, result);

        return;

    }
}


//Solution-2

// TimeComplexity: O(n) where n is number of nodes
// SpaceComplexity: O(w) where w is width of the tree. 
// Explanation: I use a breadth-first search with a queue to traverse the tree level by level. For each iteration, I record the current queue size, which represents the
// number of nodes at that level, process exactly those nodes, store their values in a list, and enqueue their left and right children. 
// This groups nodes naturally by depth and produces the level-order result.


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> inter = new ArrayList<>();
            for(int i =0; i<size; i++) {
                TreeNode curr = q.poll();
                inter.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(inter);
        }
        return result;
        
    }
}