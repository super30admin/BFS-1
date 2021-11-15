i//Time COmplexity: O(n)
//Space Complexity: O(n)
//running on leetcode: yes
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //base case
        if (root == null)
        {
            return new ArrayList<>();
        }
        //output result list
        List<List<Integer>> result = new ArrayList<>();
        //queue for bfs traversal
        Queue<TreeNode> q = new LinkedList<>();
        //add root node to the queue
        q.add(root);
        //traverse the tree BFS
        while (!q.isEmpty())
        {
            //get size for the current level
            int size = q.size();
            //list of integers to store elements at current level
            List<Integer> li = new ArrayList<>();
            //traverse level of the tree
            for (int i=0; i<size; i++)
            {
                //pop the front element of the queue and add value to the list li
                //popped element is of type TreeNode
                TreeNode curr = q.poll();
                li.add(curr.val);
                //check for valid left and right child of the curr node
                //if valid (exist) add left and right child of curr to the queue
                if (curr.left != null)
                {
                    q.add(curr.left);
                }
                if (curr.right != null)
                {
                    q.add(curr.right);
                }
            }
            //out of for loop is end of one level
            //add the list li to the result list of lists
            result.add(li);
        }
        //out of while loop, tree is traversed
        return result;
    }
}
