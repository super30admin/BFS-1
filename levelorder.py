"""
TC:O(n)
SC:O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        levels=[]
        if not root:
            return levels
        stack=[(root,0)]
        while stack:
            curr_node, level = stack.pop()
            if len(levels)==level:
                levels.append([])
            levels[level].append(curr_node.val)
            if curr_node.right:
                stack.append((curr_node.right, level + 1))
            if curr_node.left:
                stack.append((curr_node.left, level + 1))
        return levels