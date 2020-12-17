# Binary Tree Level Order Traversal

# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes with Runtime: 36 ms and Memory Usage: 15.3 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using recursive approach, the question can be solved.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        levels = [] # Initializing Stack
        if not root: # Edge Case
            return levels
        
        def dfs(node, level):
            if len(levels) == level:
                levels.append([]) # adding current node value
            levels[level].append(node.val)
            if node.left: 
                dfs(node.left, level + 1)
            if node.right:
                dfs(node.right, level + 1)
            
        dfs(root, 0)
        return levels
