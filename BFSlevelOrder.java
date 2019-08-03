// BFS solution
// Time complexity -> 0(n)  as traversing all elents in tree. level * no of elements at each level 
// Space complexity -> 0(n) stroring n elements in list
class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
           int count = queue.size();
           List<Integer> temp = new ArrayList<>();
           for(int i=0;i<count;i++){
               TreeNode node = queue.poll();
               if(node.left!=null) queue.add(node.left);
               if(node.right!=null) queue.add(node.right);
               temp.add(node.val);
           }
            result.add(temp);
        }
        
        return result;
    }
    
 
}