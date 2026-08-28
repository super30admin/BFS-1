#Time Complexity: O(n)
#Space Complexity: O(n)

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
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        """self.result = []
        self.helper(root, 0)
        return self.result

    def helper(self, root, height):
        if root is None: return
        if height == len(self.result):
            self.result.append([])
        self.result[height].append(root.val)
        self.helper(root.left, height + 1)
        self.helper(root.right, height + 1)"""
        if root is None: return []

        result = []
        q = deque([root])

        while q:
            size = len(q)
            temp = []
            for i in range(size):
                curr = q.popleft()
                temp.append(curr.val)
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
            result.append(temp)

        return result