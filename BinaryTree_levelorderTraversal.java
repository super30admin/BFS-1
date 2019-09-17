//Time complexity: O(n) (as it traverse every node in the tree)
//Space Complexity: O(1) (no extra space used)
//Tried on leetcode: accepted
//attempts: 2
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        //Initialise a result List of List to store the level order
        List<List<Integer>> result = new ArrayList<>();
        //If the root itself is null that is if the tree itself is empty return the result
        if(root == null)
        {
            return result;
        }
        //Initialize a Queue as BFS uses Queue
        Queue <TreeNode> queue = new LinkedList<>();
        //Add the root to the queue as in the first level we know that we have the root element
        queue.add(root);
        //As long as the queue is not empty
        while(!queue.isEmpty())
        {
            //Find the size of the queue
            int size = queue.size();
            //Initialise a new list to store the values of the current level
            List<Integer> currentlevel = new ArrayList<>();
            //Run a for loop over this queue
            for(int i = 0; i< size; i++)
            {
                //Remove the current element from the queue
                TreeNode current = queue.remove();
                //add this value to the current level
                currentlevel.add(current.val);
                //Check if the current node has children
                if(current.left!=null)
                {
                    //Add ledt child of the current value tp the queue if it has one
                    queue.add(current.left);
                }
                if(current.right!=null)
                {
                    //add roght child of the current element to  the queue if it has one
                    queue.add(current.right);
                }
            }
            //add the level to the result list
            result.add(currentlevel);
        }
        //Return the final list
        return result;
    }
}