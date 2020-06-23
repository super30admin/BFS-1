#LC 199 - Binary Tree Right Side View
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
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        q = deque()
        q.append(root)
        ans = []
        while q:
            l = len(q)
            for i in range(l):
                node = q.popleft()
                if i == l-1:
                    ans.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return ans