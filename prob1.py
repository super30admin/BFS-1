# Binary Tree Level Order Traversal

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Recursively traversing the tree using DFS. An empty list is created for each level of the tree and the values are appended to the respective level list.
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res
        def helper(root, height):
            if not root:
                return res
            if height == len(res):
                res.append([])
            res[height].append(root.val)
            helper(root.left, height+1)
            helper(root.right,height+1)
            
        helper(root,0)
        return res

        