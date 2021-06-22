// Time Complexity - O(N)
// Space Complexity - O(N)


class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();;
    public List<List<Integer>> levelOrder(TreeNode root) {

        //base case
        if(root == null) return levels;

        helper(root,0);

        return levels;


    }

    public void helper(TreeNode root, int level) {

        // start at the current level
        if(levels.size() == level)
            levels.add( new ArrayList<>());

        // fulfill by adding vals at the current level
        levels.get(level).add(root.val);


        // processing child nodes for the next level
        if(root.left != null) {

            helper(root.left,level + 1);

        }

        if(root.right != null) {

            helper(root.right,level + 1);

        }




    }


}