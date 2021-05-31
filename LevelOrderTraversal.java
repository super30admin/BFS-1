// Time : O(n) where n = number of nodes
// Space : O(2^h) where h = height of tree
// Did it run successfully on leetcode : yes
// Did you face any problem : No

class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //list to store result
        List<List<Integer>> res = new ArrayList<>();
        //if root is null
        if(root==null) return res;
        //queue for BFS traversal
        Queue<TreeNode> q = new LinkedList<>();
        //adding root to queue
        q.add(root);
        //loop until queue is not empty
        while(!q.isEmpty()){
            //get size of que for level order traversal
            int size = q.size();
            //list to store elements with same level
            List<Integer> tmp = new ArrayList<>();
            //looping through all the nodes in the same level
            for(int i=0; i<size; i++){
                //get the leftmost node
                TreeNode curr = q.poll();
                //add the curr node value to tmp
                tmp.add(curr.val);
                //if curr has left child add it to queue
                if(curr.left != null){
                    q.add(curr.left);
                }
                //if curr has right child add it to queue
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            //add all the current children in same level in the res
            res.add(tmp);
        }

        return res;
    }
}