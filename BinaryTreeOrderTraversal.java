//Time Complexity: O(n)
//Space Complexity: O(n)
public class BinaryTreeOrderTraversal {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int index) {
        if(root == null) return;

        if(result.size() == index) {
            List<Integer> li = new ArrayList<>();
            li.add(root.val);
            result.add(index, li);
        } else{
            result.get(index).add(root.val);
        }
        index++;
        helper(root.left, index);
        helper(root.right, index);
    }
}
