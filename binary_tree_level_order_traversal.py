"""
Problem: 102. Binary Tree Level Order Traversal
Leetcode: https://leetcode.com/problems/binary-tree-level-order-traversal/
Solution: Iterative
 with BFS, we'll keep nodes of each tree level in the queue structure because of FIFO pattern
Time Complexity: O(N), since each node is processed exactly once
Space Complexity: O(N), to keep the output structure which contains N node values
"""

# in Python the queue implementation with a fast atomic append() and popleft() is deque.
from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # base case
        levels = []
        if not root:
            return levels

        level = 0
        # add the root to queue
        queue = deque([root,])

        # iterate over the tree
        while queue:
            # start the current level
            levels.append([])
            # number of elements in the current level
            level_length = len(queue)

            for i in range(level_length):
                # deque has been optimized to do popleft() approximately in O(1), while list.pop(0) takes O(n)
                node = queue.popleft()
                # fulfill the current level
                levels[level].append(node.val)

                # add child nodes of current level in the queue for the next level
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            # go to next level
            level += 1
        return levels
