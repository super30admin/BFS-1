// Time Complexity : O(n)
// Space Complexity : O(diameter)-max number of childrens/leafs
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> l = new ArrayList<>();
        if (root == null)
            return l;

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();

                temp.add(x.val);

                if (x.left != null)
                    q.add(x.left);
                if (x.right != null)
                    q.add(x.right);
            }

            l.add(temp);
        }

        return l;

    }
}