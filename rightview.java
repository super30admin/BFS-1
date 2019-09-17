//Time complexity: O(n) (as it traverse every node in the tree)
//Space Complexity: O(n) (iterating over everynode in each level)
//Tried on leetcode: accepted
//attempts: 3
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleValues = new ArrayList<>();
        //Check if empty return visiblevalues
        if(root==null)
        {
            return visibleValues;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        //Add root to queue first level
        queue.add(root);
        //as long as not empty queue
        while(!queue.isEmpty())
        {
            //store size of queue
            int size = queue.size();
            //Iterate over the queue
            for(int i=0; i<size;i++)
            {
                //To store current element 
               TreeNode current = queue.remove();
               //Check if the current node is the last element in the level from right
                if(i==size-1)
                {
                    //add to visiblevalues
                    visibleValues.add(current.val);
                }
                //Check if it has left or right child if yes add to queue
                if(current.left!=null)
                {
                    queue.add(current.left);
                }
                if(current.right!= null)
                {
                    queue.add(current.right);
                } 
            }
            
        }
        //Return the visible elements
        return visibleValues;
    }
}