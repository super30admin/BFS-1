# Time Complexity :O(n) where n is no of nodes
# Space Complexity :O(Maximum width)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode :102

# Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

# For example:
# Given binary tree [3,9,20,null,null,15,7],
# 3
# / \
#     9
# 20
# / \
#     15
# 7
# return its level order traversal as:
# [
#   [3],
#   [9,20],
#   [15,7]
# ]

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from collections import deque


class Solution(object):
    def __init__(self):
        self.res = []

    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []

        queue = deque()

        queue.append(root)

        while queue:
            queueSize = len(queue)
            tempArray = []
            for index in range(queueSize):
                parent = queue.popleft()
                tempArray.append(parent.val)

                if parent.left:
                    queue.append(parent.left)
                if parent.right:
                    queue.append(parent.right)

            self.res.append(tempArray)

        return self.res

root = TreeNode(3,TreeNode(9),TreeNode(20))
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)

print(Solution().levelOrder(root))
