// Time Complexity : O(n)
// Space Complexity: O(n)
// Did it run on LeetCode : Yes, 1ms
// Did you face any problems while attemmpting? : No

// Approach: Basic Idea is to put the nodes in the queue, and explore its left and right child, and since the order of insertion is left and right, once we reach size - 1, 
// we are at the right node, and we add it to the list

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        
        if(root == null){
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                TreeNode temp = queue.poll();
                
                if(temp.left != null){
                    queue.add(temp.left);
                }
                
                if(temp.right != null){
                    queue.add(temp.right);
                }
                
                if(i == size-1){
                    list.add(temp.val);
                }

            }

        }

        return list;
    }
}

