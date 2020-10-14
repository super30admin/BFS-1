class Solution {// time and space of O(n) or can say space of O(diameter of tree)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        //Base case 
        if(root == null)
            return list;
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size= queue.size();
            TreeNode temp;
            List<Integer> sublist = new ArrayList<>();
            
            for(int i =0 ; i<size ; i++){
                temp = queue.poll();
                sublist.add(temp.val) ;
                if(temp.left !=null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right); 
            }
            list.add(sublist);
        }
        return list;
    }
}