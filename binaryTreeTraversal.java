//queue to traverse level by level, collecting node values into a list for each level. At each level, it processes all nodes in the queue and adds their children back to the queue for the next round.
//Time Complexity: O(n)
//Space complexity: O(n)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        if(root==null) return result;
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int level=queue.size();
            List<Integer> list= new ArrayList<>();

            for(int i=0;i<level;i++)
            {
                TreeNode node= queue.poll();
                list.add(node.val);

                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }

            result.add(list);
        }

        return result;

    }
}
