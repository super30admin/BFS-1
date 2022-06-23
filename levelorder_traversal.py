# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
-- Passed test cases on LeetCode
'''
# Recursion Approach
class Solution:
    #O(N) -- Time complexity where n is the number of nodes; O(N) -- Space complexity for the recursive stack to store nodes.
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        level = []
        if not root:
            return level
        def getLevel(node, levels):
            if len(level) == levels:
                level.append([])
            level[levels].append(node.val)
            
            if node.left:
                getLevel(node.left, levels + 1)
            if node.right:
                getLevel(node.right, levels + 1)
                   
        getLevel(root, 0)
        return level
            
            
        
