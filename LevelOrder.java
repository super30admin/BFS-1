//Time Complexity: O(n)
//Space Complexity: O(n)

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> mainQueue = new LinkedList<>();
        Queue<TreeNode> temp = new LinkedList<>();

        List<Integer> current;
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        mainQueue.add(root);
        while(!mainQueue.isEmpty()){
            current = new ArrayList<>();

            for(TreeNode node: mainQueue){
                current.add(node.val);
                if(node.left!=null)
                    temp.add(node.left);
                if(node.right!=null)
                    temp.add(node.right);
            }
            result.add(current);
            mainQueue = temp;
            temp = new LinkedList<>();
        }

        return result;


    }
}
