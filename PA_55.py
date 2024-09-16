#LC 102 - Binary Tree Level Order Traversal
#Time Complexity - O(n)
#Space Complexity - O(h)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        self.ans = []
        def helper(root,depth):
            if not root:
                return
            if depth == len(self.ans):
                self.ans.append([])
            self.ans[depth].append(root.val)
            helper(root.left,depth+1)
            helper(root.right,depth+1)
        helper(root,0)
        return(self.ans)
        