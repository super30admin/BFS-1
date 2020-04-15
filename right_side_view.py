"""
// Time Complexity : O(V + E) 
// Space Complexity : O(V + E)  //height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Method1 - Level order traversal -BFS
- Use queue to run the BFS on the tree while tracking the level 
with size of the queue
- Add the root val to result only when index is equal to size - 1 
(last index)

Method2 - modified DFS - level order traversal
Since we want the right side view, we recurse through right first,then 
root and then left so that we have the tracking of when to add the
root val 
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        
        #Method1 - Level order traversal
        """
        Appending the root to list only if index of elements in the 
        queue is equal to size(results) - 1
        """
        
        if not root:
            return []
        queue = []
        queue = [root]
        results = []
        while queue:
            size = len(queue)
            for i in range(size):
                root = queue.pop(0)
                if i == size - 1:
                    results.append(root.val)
                
                if root.left:
                    queue.append(root.left)
                if root.right:
                    queue.append(root.right)
        return results
    
        #Method2 - DFS rec for level order traversal ( with Right,Root,Left direction )
        results = []
        def dfs(root,depth):
            if not root:
                return
            if depth == len(results):
                results.append(root.val)
            dfs(root.right,depth+1)
            dfs(root.left,depth+1)
        
        dfs(root,0)
        return results