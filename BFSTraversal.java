/**
 * 
 * Time Complexity O(n) if we consider as graph then O(V)
 * Space Complexity O(h) where h is height of the tree
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                temp.add(curr.val);
                
                if(curr.left!=null)
                    q.add(curr.left);
                
                if(curr.right!=null)
                    q.add(curr.right);
                //result.add(temp);
            }
            result.add(temp);
        }
        return result;
    }
}