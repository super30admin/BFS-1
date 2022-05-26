# Time Complexity : O(N) where N is number of nodes in the birnary tree
# Space Complexity : O(H) where h is height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque 
class Solution:
    def __init__(self):
        self.result = []
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None: return []
        
        self.dfs(root, 0)      
            
        return self.result
    
    def dfs(self, root, level):
        if root is None: return
        
        if len(self.result) == level:
            self.result.append([root.val])
        else:
            self.result[level].append(root.val)
        
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)