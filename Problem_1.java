/*

Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

TC : O(n)
SC : O(n)
Leet Code : Yes

 */

 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null){
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}