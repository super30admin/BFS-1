// Time Complexity :
//      n is the number of nodes in tree
//      h is the number of levels
//      levelOrder() - O(n)
//      
// Space Complexity :
//      levelOrder() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Stores the level info in the queue along with Treenode

class Solution {
    List<List<Integer>> li = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null)
            return li;
        
        Queue<Pair<TreeNode, Integer>> qu = new LinkedList<Pair<TreeNode,Integer>>();
        qu.offer(new Pair(root, 0));
        
        List<Integer> paths = new ArrayList<>();
        int curr = 0;
        
        while(!qu.isEmpty())
        {
            Pair<TreeNode, Integer> temp = qu.poll();
            if(temp.getValue() == curr)
            {
                paths.add(temp.getKey().val);
            }
            else
            {
                ++curr;
                li.add(paths);
                paths = new ArrayList<>();
                paths.add(temp.getKey().val);
            }
            
            if(temp.getKey().left != null)
                qu.offer(new Pair(temp.getKey().left, temp.getValue()+1));
            if(temp.getKey().right != null)
                qu.offer(new Pair(temp.getKey().right, temp.getValue()+1));
        }
        
        li.add(paths);
        
        return li;
    }
}


// Time Complexity :
//      n is the number of nodes in tree
//      levelOrder() - O(n)
//      
// Space Complexity :
//      levelOrder() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Do not store level info in the queue

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> li = new ArrayList<>();
        
        if(root == null) return li;
        
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.offer(root);
        
        List<Integer> paths = new ArrayList<>();
        
        int size = qu.size();
        
        while(!qu.isEmpty())
        {
            TreeNode temp = qu.poll();
            if(size > 0)
            {
                paths.add(temp.val);
                --size;
            }
            
            if(temp.left != null)
                qu.offer(temp.left);
            if(temp.right != null)
                qu.offer(temp.right);
            
            if(size == 0)
            {
                li.add(paths);
                size = qu.size();
                paths = new ArrayList<>();
            }
        }
        
        return li;
    }
}
