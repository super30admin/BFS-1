
//BFS
// Time Complexity - O(n) where n is the number of nodes in the tree
// Space Complexity - O(B) where B is the breath of the tree
// This solution worked on LeetCode


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();       // Create a resultant List for output
        if(root == null)    return result;              //If root is null return empty result list
        Queue<TreeNode> q = new LinkedList<>();     
        q.add(root);                                    // Add the root to the queue
        int size =0;                                    // Size is used to keep record the length of level 
        while(!q.isEmpty()){        
            size = q.size();                            // size will be the number of elements in the queue which are levels of the tree
            Integer temp =0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();                       // Poll the node
                temp = node.val;                                // Use the temp variable that will used to get the most recent which is the rightmost node value in the queue
                if(node.left != null) q.add(node.left);         // Add the left child of the node to the queue
                if(node.right != null) q.add(node.right);       // Add the left child of the node to the queue
            }
            result.add(temp);
        }
        return result;
    }
}

// DFS
// Time Complexity - O(n)
// Space Complexity - O(1) since we are not using any extra space apart from the recursion stack.
// This solution worked on LeetCode
// In this DFS solution, the root is processed and then it's right child is processed first since we have to get the right side view of the tree. Once the right childs are completed, we move to the left side. For adding node it is checked if the node depth is equal to the result size. If it is equal it means the node will be visible from right side view and the existing elements in the result list will not obstruct the view. If the depth is less than the result list size it means the elements in the result list will obstruct the view of this node. The recursive solution will process all the right children first and then all the left children of the tree. Similarly if we need the left view of the tree we will process all the left children first and then the right child nodes.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)    return result;
        helper(root,0,result);
        return result;
    }
    private void helper(TreeNode root, int depth,List<Integer> result){
        if(root == null)    return;
        if(result.size() == depth)  
            result.add(root.val);
        helper(root.right, depth+1, result);
        helper(root.left, depth +1, result);
    }
}
