
//Time Complexity: O(n) where n is the number of nodes in the tree
//Space Complexity: O(n) where n is the maximum number of nodes at any level


//We will use a queue to perform BFS on the tree
//We will keep track of the current level's nodes and their values
//We will add the current level's values to the outer list
//We will continue this process until we have traversed all levels of the tree

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outer=new ArrayList<>();
        if(root==null)  // if the root is null, return an empty list
            return outer;
        Queue <TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz=q.size();
            List<Integer> inner=new ArrayList<>();  //create a new list for every level
            for(int i=0;i<sz;i++){
                TreeNode f=q.remove();
                inner.add(f.val);
                if(f.left!=null)
                    q.add(f.left);
                if(f.right!=null)
                    q.add(f.right);
            }
            outer.add(inner);
        }
        return outer;
    }
}