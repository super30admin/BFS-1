// Time Complexity : O(N)
// Space Complexity : O(M/2) = O(M) -- where M is max no of noded in level //which is leaf nodes level at the bottom 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Iterative Approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)    return result;
        
        Queue<TreeNode> queue = new LinkedList<>();// Created a queue
        
        queue.add(root);//Root added into Queue
        
        while(!queue.isEmpty()){
            int len = queue.size();  //Current size of Queue
            List<Integer> temp = new ArrayList<>();
            
            while(len-- > 0){ // Value of len times, we will remove node from queue and adding that node into list, and add left and right child of that node
                TreeNode node = queue.poll();
                temp.add(node.val);
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                
            }
            
            result.add(temp); //After doing above process for len times, add list into result list
        }
        
        
        return result;
    }
}
//Using recursion
/*
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        levelOrder(root, 0);
        return result;
    }
    public void levelOrder(TreeNode root, int h){
        if(root == null)    return;
        
        if(result.size() == h)  result.add(new ArrayList<>());
        
        result.get(h).add(root.val);
        
        levelOrder(root.left, h + 1);
        levelOrder(root.right, h + 1);
    }
}

*/
