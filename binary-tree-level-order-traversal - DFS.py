# Time complexity: O(n) where n is the number of nodes
# Space complexity: O(h) where h is the height of the Tree

# The code successfully ran on Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
        
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None: return self.result
        
        self.dfs(root, 0)
        
        return self.result
    
    def dfs(self, root, lvl):
        # Base
        if root == None: return
        
        # Logic
        if len(self.result)== lvl:
            self.result.append([])
            
        self.result[lvl].append(root.val)
        
        self.dfs(root.left, lvl + 1)
        self.dfs(root.right, lvl + 1)