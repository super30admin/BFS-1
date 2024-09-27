//////////////////////////////////////// recursive approach

// Time Complexity : O(n) since we traverse all the nodes
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// we have a helper with params as root, res and level 
// remember res is passed as reference 
// here we recursively call the root.left and root.right for level+1 and pass on the res(result list)
// also in the helper function we check the res has size > level if not create a new array list
// first we get the list at that level (res.get(level)) and then add roo.val to that list
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        helper(root, res, 0);

        return res;

    }

    private void helper(TreeNode root, List<List<Integer>> res, int level) {

        if (root == null)
            return;

        // if res.size() is big enough to handle else create a new arraylist before hand
        if (level >= res.size()) {
            res.add(new ArrayList());
        }

        // inorder to add the height, it should be present so thats why we put the above
        // line so as to make sure.

        res.get(level).add(root.val);

        // res.add(level, root.val); this wont work because we cant add integers to
        // res[level] we have to add list

        helper(root.left, res, level + 1);

        helper(root.right, res, level + 1);

    }
}

////////////////////////////////////////////////////// Iterative approach

// Time Complexity : O(n) since we traverse all the nodes
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/**
 * first we add the root to the queue
 * 
 * (till the queue is empty)at each iteration we save the number of nodes we
 * have to process at that level in "size" variable, and create a new sublist
 * for that level
 * 
 * in for loop for i =0 to size, we add the children(if not null) to the queue,
 * but this changes the size of queue so we stored it in size
 * 
 * at the end of each while loop we add the sublist to the main list
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> ls = new ArrayList<>();
            // imp store the size at that level in the "size" variable ..since we are
            // changing the queue multiple times
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                ls.add(temp.val);
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }
            res.add(ls);
        }

        return res;
    }
}