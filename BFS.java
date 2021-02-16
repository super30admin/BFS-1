class BFS{
    public List<List<Integer>> levelOrder(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> treeList = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
         if(root==null)
            return finalList;
        queue.add(root);
        queue.add(null); 
        
        while(!queue.isEmpty()){
            System.out.println("Before"+queue);
            TreeNode temp = queue.poll();
            System.out.println("After"+queue);
            if (temp == null) { 
                if(!queue.isEmpty()) { 
                  queue.add(null); 
                  finalList.add(treeList);
                  treeList = new ArrayList<>();  
                } 
            }
            else{
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                treeList.add(temp.val);
            }
        }

        finalList.add(treeList);
        return finalList;
    }
}