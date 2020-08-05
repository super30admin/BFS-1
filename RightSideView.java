/**

// Time Complexity : O(n)
// Space Complexity : O(s) size of each level
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
// using level order traversal, then get the right most node in each level.
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();

        if(root != null){
            qu.offer(root);
            ret.add(root.val);
        }

        while(!qu.isEmpty()){
            LinkedList<TreeNode> temp = new LinkedList<>();
            while(!qu.isEmpty()){
                TreeNode node = qu.poll();
                if(node.left != null)
                    temp.add(node.left);
                if(node.right != null)
                    temp.add(node.right);
            }
            if(temp.size() > 0)
                ret.add(temp.getLast().val);
            qu.addAll(temp);
        }
        return ret;
    }
}
