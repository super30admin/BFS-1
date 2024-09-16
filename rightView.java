//Time Complexity: O(n) 
//Space Compexity: O(n)
//Program ran successfully
/*
    Algorithm: 1. Perform BFS using a queue
               2. Add the last element at each level into the result array
*/
class rightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int lastEl = 0;
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                lastEl = temp.val;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            result.add(lastEl);
            index++;
        }
        return result;
    }
}
