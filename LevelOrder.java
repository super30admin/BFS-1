/**
// Time Complexity : O(n)
// Space Complexity : O(s) size of each level
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        if(root != null)
            qu.offer(root);

        //walk elems in qu.
        while(!qu.isEmpty()){
            //add all elems in one level  in one qu temp.
            List<Integer> tempret = new ArrayList<>();
            Queue<TreeNode> temp = new LinkedList<>();

            //pop elems in qu. and add next level to temp.
            while(!qu.isEmpty()){
                TreeNode node = qu.poll();
                tempret.add(node.val);
                if(node.left != null)
                    temp.offer(node.left);
                if(node.right != null)
                    temp.offer(node.right);
            }
            //add all elems from temp to qu.
            ret.add(tempret);
            qu.addAll(temp);
        }

        return ret;
    }
}
