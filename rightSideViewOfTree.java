 */
class Solution {
    List<Integer>  result;
    public List<Integer> rightSideView(TreeNode root) {
        result= new ArrayList<>();
        //edge case 
        if(root == null)
            return result;
        rightSideViewUtilDFS(root, 0);
        rightSideViewUtilBFS(root);
        return result;
    }
    /* DFS solution
    Time complexity : O(n) as we are visiting all the nodes
    Space complexity : O(H), maximum nodes in the stack would be height of the tree as we are popping       out the nodes
    */
    private void rightSideViewUtilDFS(TreeNode root, int level){
        if(root == null)
            return ;
        if(level ==  result.size())
            result.add(root.val);
        rightSideViewUtilDFS(root.right, level+1);
        rightSideViewUtilDFS(root.left, level+1);
       
    }
    /* BFS solution
    Time complexity : O(n) as we are visiting all the nodes
    Space complexity : O(2n), in worst case if its a complete binary tree then maximum number of nodes     is going to lie on the deepest level which would be O(2n) and that is equal to O(n)
    */
    private void rightSideViewUtilBFS(TreeNode root){
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=1; i<=size; i++){
                TreeNode temp = queue.poll();
                if(i== size)
                    result.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);               
            }
        }      
    }
}
