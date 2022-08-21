// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * BFS solution using a queue. Nothing Fancy and just the old boring way.
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        // Put the root into the queue
        q.add(root);
        
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            result.add(new ArrayList<>());
            
            for (int i=0;i<size;i++) {
                
                TreeNode currNode = q.poll();
                
                result.get(result.size() - 1).add(currNode.val);
                
                if (currNode.left != null) q.add(currNode.left);
                if (currNode.right != null) q.add(currNode.right);
            }
        }
        
        return result;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * DFS solution using recursion and in-built recursive stack
 * We will put the depth and node into the recursive stack
 * At each level, we put the node's value into the result ArrayList
 * once the recursion stops, we have the result array populated.
 */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        
        dfs(root, 0);
        
        return result;
    }
    
    private void dfs(TreeNode root, int depth) {
        // base
        if (root == null) return;
        
        // Logic
        if (depth == result.size()) {
            result.add(new ArrayList<>());
        }
        
        result.get(depth).add(root.val);
        
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * DFS solution using irerative approach and explicit recursive stack
 * We will put the depth and node into two different stacks
 * At each level, we put the node's value into the result ArrayList
 * once the stack is empty (we processed all the nodes), we have the result array populated.
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;
        
        // This stack will act as our recursive stack for processing Nodes
        Stack<TreeNode> nodeStack = new Stack<>();
        
        // This stack will act as our recursive stack for processing depths for the node
        Stack<Integer> depthStack = new Stack<>();
        
        
        // Insert root and depth into respective stack
        nodeStack.push(root);
        depthStack.push(0);
        
        while(!nodeStack.isEmpty()) {
            // pop the top element and depth for processing
            TreeNode currNode = nodeStack.pop();
            int currDepth = depthStack.pop();
            
            if (currDepth == result.size()) {
                result.add(new ArrayList<>());
            }
            
            result.get(currDepth).add(currNode.val);
            
            // process the right nodes first and then left node.
            // As we will get left node and then right when processing the stack
            if (currNode.right != null) {
                nodeStack.push(currNode.right);
                depthStack.push(currDepth + 1);
            }
            if (currNode.left != null) {
                nodeStack.push(currNode.left);
                depthStack.push(currDepth + 1);
            }
        }
        
        return result;
    }
}
