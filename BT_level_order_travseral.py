# Time Complexity : O(n), where n is the number of nodes in the tree. Each node is visited once.
# Space Complexity : O(n), for the queue used in BFS and the result list.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used a Breadth-First Search (BFS) approach using a queue.
# For each level, I processed all nodes at that level before moving to the next.
# I added the left and right children of the current node to the queue.
# I collected values level by level into a result list and returned it.

from collections import deque
from typing import Optional, List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        result = []
        queue = deque([root])  # I started the BFS with the root node

        while queue:
            level_size = len(queue)
            level = []

            for _ in range(level_size):  # I processed all nodes at the current level
                node = queue.popleft()
                level.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            result.append(level)

        return result
