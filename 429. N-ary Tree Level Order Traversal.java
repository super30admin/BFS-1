class Solution {//Time and space of O(n)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        //Base case 
        if(root == null)
            return list ;
        queue.add(root);
        
        while(!queue.isEmpty()){
            Node temp;
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i = 0; i< size ; i++){
                temp = queue.poll();
                sublist.add(temp.val);
                if(temp.children != null)
                    queue.addAll(temp.children);
            }
            list.add(sublist);
        }
        return list ;
    }
}