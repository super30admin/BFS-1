/*
from collections import deque
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        
        result = []
        
        q = deque()
        q.append(root)
        while len(q) != 0:
            temp = []
            size = len(q)
            for i in range(size):
                popped = q.popleft()
                temp.append(popped.val)
                
                if popped.left is not None:
                    q.append(popped.left)
                
                if popped.right is not None:
                    q.append(popped.right)
            result.append(temp)
        
        return result
*/
/*
level order traversal with dfs approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        
        if (root == null)
            return result;
        
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        if (root == null)
            return;
        
        if (result.size() == level)
            result.add(new ArrayList<>());
        
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

*/


// Time Complexity : O(n) where n is no of nodes in tree
// Space Complexity : O(2^h) where h is the heigth of tree. Worst would be when queue will have all the nodes at last level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: Maintained a queue for bfs and created a new arraylist each time
// we traverse to another level
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            
            for (int i=0; i<size; i++){
                TreeNode popped = q.poll();
                temp.add(popped.val);
                
                if (popped.left != null)
                    q.add(popped.left);
                
                if (popped.right != null)
                    q.add(popped.right);
            }
            
            result.add(temp);
        }
        return result;
    }
}