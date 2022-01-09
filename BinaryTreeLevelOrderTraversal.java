// Time Complexity :O(N) N is the number of nodes
// Space Complexity :O(N/2) as we only have to deal with n/2 elements at a time in our bfs queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We do a classic BFS approcah and check every node in levels where siblings are check first and then we go to the baby nodes.
//We take a node, visit it and then add to queue.
//We poll the node and check if the kids are valid, if yes, we add the nodes to the queue.


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //base check
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right !=null){
                    q.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}