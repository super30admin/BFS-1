// Time Complexity :O(N) ---> we process each and every node in the tree
// Space Complexity :O(N) ---> and store it in an result
// Did this code successfully run on GeeksforGeeksEditor : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null)
            return res;
        //to store currlevel elements
        Queue<TreeNode> curr = new LinkedList<>();
        //to store nextlevel elements
        Queue<TreeNode> next = new LinkedList<>();
        //add root to current queue
        curr.add(root);
        List<Integer> currLevelNodes = new ArrayList<>();
        while(!curr.isEmpty()){
            TreeNode node = curr.remove();
            currLevelNodes.add(node.val);
            if(node.left != null) next.add(node.left);
            if(node.right != null) next.add(node.right);
            
            if(curr.isEmpty()){
            	//once added currlevel make currqueue to next and initialise new list
                res.add(currLevelNodes);
                currLevelNodes = new ArrayList<>();
                curr = next;
                next = new LinkedList<>();
            }
        }
        return res;
    }
}