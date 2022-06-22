
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

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
        queue = deque([root])
        levels = []


        def bfs():
            while queue:
                level = []

                size = len(queue)

                for i in range(size):

                    element = queue.popleft()
                    level.append(element.val)
                    if element.left:
                        queue.append(element.left)
                    if element.right:
                        queue.append(element.right)
                levels.append(level)


        def dfs(level, node):
            if not node:
                return
            size = len(levels)
            if size == level:
                levels.append([])
            levels[level].append(node.val)
            if node.left:
                dfs(level+1, node.left)
            if node.right:
                dfs(level+1, node.right)

        bfs()
        dfs(0, root)   
        return levels