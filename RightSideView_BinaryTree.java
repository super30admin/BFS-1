/*
    BFS solution

    time complexity : O(N)
    space complexity : at most n/2 node at last level in the queue that's wht O(N)
    worked on leetcode : YES

*/

public class RightSideView_BinaryTree {
    List<Integer> res ;
    public List<Integer> rightSideView(TreeNode root) {
        
        res = new ArrayList();
        if (root == null ) return res;
        Queue<TreeNode> q =  new LinkedList<>();
        q.add(root);
        
        while( !q.isEmpty()){
            int size = q.size();
            
            while(size-- > 1){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            // take it out most rightnode which is the last node present at current level in tree
            TreeNode _node = q.poll();
            res.add(_node.val);
            
             if(_node.left != null) q.add(_node.left);
             if(_node.right != null) q.add(_node.right);
        }
        return res;
    }
}