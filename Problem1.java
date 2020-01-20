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