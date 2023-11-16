# Time Complexity: O(N) : where N is the number of Nodes
# Space Complexity: O(H) : Space Complexity of the Recursion Stack. H is the Height of the tree

# I maintain a Level variable as part of the DFS recursion to add the nodes of the current level to the result.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        self.result = []
        if root is None:
            return self.result
        
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root: Optional[TreeNode], level: int) -> None:

        if root is None:
            return

        if len(self.result) == level:
            self.result.append([])
        
        self.result[level].append(root.val)
        if root.left:
            self.dfs(root.left, level + 1)
        
        if root.right:
            self.dfs(root.right, level + 1)
