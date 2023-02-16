class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>() ; 
        Queue<TreeNode> q = new LinkedList<>() ; 
        
        if(root == null){
            return result ; 
        }
        q.add(root);

        while(!q.isEmpty()){
            ArrayList<Integer>storage = new ArrayList<>() ; 
            int size = q.size();
            // storage.add(val) ; 
            //System.out.print(val) ; 
            for(int i = 0 ; i < size ; i ++){
                TreeNode curr = q.poll() ;

                storage.add(curr.val) ; 

                if(curr.left != null){
                    q.add(curr.left) ; 
                }

                if(curr.right != null){
                    q.add(curr.right) ; 
                } 
            }

            result.add(storage) ; 
            
        } 

        return result ; 
    }


}
