//Time Complexity: O(n)
//Space Complexity: O(n/2)= O(n)

//BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        //Adding elements to the queue and looping through it
        while(!q.isEmpty()){
            List <Integer> temp = new ArrayList<>();
            int size = q.size(); //to keep a track of the the number of nodes at each level
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll(); //Removing nodes based on their height in the tree: Nodes at the same height come after each other
                temp.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);    
            }
            result.add(temp);
        }
        return result;
        
    }
}