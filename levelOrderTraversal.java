class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        //edge case
        if(root == null)
            return res;
        //dfs
        //levelOrderUtilDFS(root, 0);
        //bfs
        levelOrderUtilBFS(root);
        return res;
    }
    /* DFS solution
    Time complexity : O(n) as we are visiting all the nodes
    Space complexity : O(H), maximum nodes in the stack would be height of the tree as we are popping out the nodes
    */
    private void levelOrderUtilDFS(TreeNode root, int level){
        //edge case
        if(root == null) return ;
        
        //create a new list for each level
        if(level == res.size())
            res.add(new ArrayList<>());
        
        //if list for particular level is already exists then current node in the list for that level
        res.get(level).add(root.val);
        
        //recursively traverse left and right subtree of current node 
        levelOrderUtilDFS(root.left, level+1);
        levelOrderUtilDFS(root.right, level+1);
    }
    /* BFS solution
    Time complexity : O(n) as we are visiting all the nodes
    Space complexity : O(2n), in worst case if its a complete binary tree then maximum number of nodes is going to       lie on the deepest level which would be O(2n) and that is equal to O(n)
    */
    private void levelOrderUtilBFS(TreeNode root){
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer>tempList = new ArrayList<>();
            int size = q.size();
            while(tempList.size() != size){
                //pop the node from the queue
                TreeNode temp = q.poll();
                //add the polled node in the list
                tempList.add(temp.val);
                //process all children of the popped node
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right); 
            }
            res.add(tempList);
        }
    }
}

