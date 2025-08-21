class LevelOrderTraversal{

    //Idea is to use queue for level order traversal and use size variable to keep track of level
    //and  add to final list for every traversal
    
    //Time Complexity: O(n)
    //Space Complexity: O(n)
        public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode front;
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
            front = q.poll();
            temp.add(front.val);
            if(front.left!=null)
            {
                q.add(front.left);
            }
            if(front.right!=null)
            {
                q.add(front.right);
            }
            }
            result.add(temp);
        }
        return result;
    }
}