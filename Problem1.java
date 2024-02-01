//Accepted on LT
//General BFS using a queue 
//Time shoould be O(n) as we are travelling all nodes.
class Solution {
    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> l = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        q.add(root);
        if(root==null){
            return l;
        }
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l1 = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode t = q.poll();
                l1.add(t.val);
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
               
                
            }
            l.add(l1);

        }
        return l;

        
    }
  
}