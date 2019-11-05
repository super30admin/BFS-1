TC:O(n)
SC:O(n)


Runtime: 1 ms, faster than 99.91% of Java online submissions for Binary Tree Right Side View.
Memory Usage: 36 MB, less than 100.00% of Java online submissions for Binary Tree Right Side View.


Approach: Just traverse level by level and add only the last element in each level


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> visibleValues = new ArrayList<>();
        if(root == null){
            return visibleValues;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){    // runs for number of levels
            
            int size = q.size();
            for(int i=0; i<size ;i++){   //  runs for each element in the current level
                TreeNode a = q.remove();  
                if(i == size-1){  // only the last element of each level is added to the list
                    visibleValues.add(a.val);
                }
                if(a.left != null){
                    q.add(a.left);
                }
                if(a.right != null){
                    q.add(a.right);
                }
                
            }
        }
        return visibleValues;
    }
}
