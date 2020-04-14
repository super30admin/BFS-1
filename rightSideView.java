//time - O(n)
//space - O(n) for the queue without considering the result
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        //BFS so use a queue
        Queue<TreeNode> support = new LinkedList<>();
        support.offer(root);
        
        while(!support.isEmpty())
        {
            int layerSize = support.size(); //get the number of nodes in each layer
            Integer node = null; //keep on replacing till the right most node is reached
            for(int i = 0; i < layerSize; i++)
            {
                //push the popped element into arraylist
                //push the left and right childer (if present) of the popped node into queue
                TreeNode front = support.poll();
                node = front.val;
                if(front.left != null)
                {
                    support.offer(front.left);
                }
                if(front.right != null)
                {
                    support.offer(front.right);
                }
            }
            result.add(node); //add that node to result
        }
        
        return result;
    }
}
