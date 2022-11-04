//TC: O(n)
//SC: O(h)
//works in leetcode

//add nodes in queue at current order
//remove node and add children in next queue

public class BinaryTreeLevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> curr = new LinkedList<>();
        curr.add(root);

        while(!curr.isEmpty()){ // loop for order - vertical

            Queue<TreeNode> next = new  LinkedList<>();

            List<Integer> orderList = new ArrayList<>();

            while(!curr.isEmpty()){  // loop for each node within order - horizontal
                TreeNode node = curr.remove();
                if(node.left!=null){
                    next.add(node.left);
                }

                if(node.right!=null)
                    next.add(node.right);

                orderList.add(node.val);
            }
            result.add(orderList);
            curr = next;
        }
        return result;

    }


    public static void main(String [] args){
        TreeNode node3 = new TreeNode(9,null,null);
        TreeNode node2 = new TreeNode(15,null,null);
        TreeNode node1 = new TreeNode(7,null,null);
        TreeNode node4 = new TreeNode(20,node2,node1);
        TreeNode head = new TreeNode(3, node3, node4);
        System.out.println(levelOrder(head));

    }

}