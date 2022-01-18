# Time Complexity: O(n)
# Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root: return []
        res, stack = [], []
        stack.append(root)
        while stack:
            temp, out = [],[]
            for value in stack:
                out.append(value.val)
                if value and value.left: temp.append(value.left)
                if value and value.right: temp.append(value.right)
            stack = temp
            res.append(out)
        return res