// Time Complexity:           O(n)
// Space Complexity:          O(n)
// where n is number of nodes in tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> cur = new LinkedList<>();
        List<Integer> curLevel = new ArrayList<>();

        cur.add(root);

        int size = 1;

        while(!cur.isEmpty()) {
            while(size > 0) {
                TreeNode node = cur.remove();
                curLevel.add(node.val);                              // adding node
                size--;

                if(node.left != null)                                // adding left child
                    cur.add(node.left);
                if(node.right != null)                               // adding right child
                    cur.add(node.right);
            }

            result.add(curLevel);                                    // adding to "result" when size becomes 0
            curLevel = new ArrayList<>();
            size = cur.size();                                       // again calculating size
        }

        return result;
    }
}




// ****************************** Using size Another Approach ******************************
//class BinaryTreeLevelOrder {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        if(root == null)
//            return result;
//
//        Queue<TreeNode> cur = new LinkedList<>();
//        List<Integer> curLevel = new ArrayList<>();
//
//        cur.add(root);
//
//        int size = 1;
//
//        while(!cur.isEmpty()) {
//
//            TreeNode node = cur.remove();
//            curLevel.add(node.val);
//            size--;
//
//            if(node.left != null)
//                cur.add(node.left);
//            if(node.right != null)
//                cur.add(node.right);
//
//            if(size == 0) {
//                result.add(curLevel);
//                curLevel = new ArrayList<>();
//                size = cur.size();
//            }
//        }
//
//        return result;
//    }
//}






// ****************************** Two Queue Approach ******************************
//class BinaryTreeLevelOrder {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        if(root == null)
//            return result;
//
//        Queue<TreeNode> cur = new LinkedList<>();
//
//        cur.add(root);
//
//        while(!cur.isEmpty()) {
//
//            Queue<TreeNode> next = new LinkedList<>();
//            List<Integer> curLevel = new ArrayList<>();
//
//            while(!cur.isEmpty()) {
//                TreeNode node = cur.remove();
//                curLevel.add(node.val);
//                if(node.left != null)
//                    next.add(node.left);
//                if(node.right != null)
//                    next.add(node.right);
//            }
//
//            result.add(curLevel);
//            cur = next;
//
//        }
//
//        return result;
//    }
//}






// ****************************** Two Queue Another Approach ******************************
//class BinaryTreeLevelOrder {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        if(root == null)
//            return result;
//
//        Queue<TreeNode> cur = new LinkedList<>();
//        Queue<TreeNode> next = new LinkedList<>();
//        List<Integer> curLevel = new ArrayList<>();
//
//        cur.add(root);
//
//        while(!cur.isEmpty()) {
//
//            TreeNode node = cur.remove();
//            curLevel.add(node.val);                            // adding node
//
//            if(node.left != null)                              // adding left child
//                next.add(node.left);
//            if(node.right != null)                             // adding right child
//                next.add(node.right);
//
//            if(cur.isEmpty()) {                                // when "cur" becomes empty
//                result.add(curLevel);
//                curLevel = new ArrayList<>();
//
//                cur = next;                                    // assigning "next" to "cur"
//                next = new LinkedList<>();
//            }
//        }
//
//        return result;
//    }
//}

