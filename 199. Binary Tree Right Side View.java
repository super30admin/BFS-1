class Solution {// time and sapce of O(n)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        //Base case 
        if(root == null)
            return list;
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size= queue.size();
            TreeNode temp = null;
           // List<Integer> sublist = new ArrayList<>();
            
            for(int i =0 ; i<size ; i++){
                temp = queue.poll();
                //sublist.add(temp.val) ;
                if(temp.left !=null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right); 
            }
            list.add(temp.val);
        }
        return list;
    }
}