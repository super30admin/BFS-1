/*TC,  SC -  O(N) , O(N)
 * Consider one level at a time using a queue*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0 ;
        while(!queue.isEmpty()){
            int length = queue.size(); // you need to keep track of length since the queue size i getting incremented in the for loop
            ans.add(new ArrayList());
            for (int i = 0; i < length; i++){

                TreeNode node = queue.poll();

                ans.get(level).add(node.val);
                if (node.left != null){
                  queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }

            }
            level += 1 ;

        }

        return ans;

    }
}
