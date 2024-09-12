class Solution {//time and space of O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        //Base case 
        if(root == null)
            return list;
        queue.add(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            int size= queue.size();
            TreeNode temp = null;
            List<Integer> sublist = new ArrayList<>(size);
            
            for(int i =0 ; i<size ; i++){
                
                temp = queue.poll();
                if(flag == true){
                sublist.add(temp.val) ;
                }else{
                    //Modification
                    sublist.add(0,temp.val);
                }
                if(temp.left !=null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right); 
            }
            flag = !flag ;
           // System.out.println(flag);
            list.add(sublist);
        }
        return list;   
    }
}