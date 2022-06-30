/*
This approach uses a BFS to print out the level order traversal of the binary tree. Starting from the root node, each
node in the tree is added to a queue level by level. Once the node has been added, it is checked whether the node had 
any children, and subsequently those children are added to the queue as well, while the initial node is popped off and
added to the result. 

Did this code run on leetcode: Yes
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            //Creating new list for the current level
            List<Integer> li = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                //Adding current node to the result
                li.add(curr.val);
                //Checking for left and right child of the node
                if(curr.left != null)
                    q.add(curr.left);
                    
                if(curr.right != null)
                    q.add(curr.right);
            }
            
            result.add(li);
        }
        return result;
    }
}