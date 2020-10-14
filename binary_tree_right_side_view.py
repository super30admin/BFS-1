"""
Problem: 199. Binary Tree Right Side View
Leetcode: https://leetcode.com/problems/binary-tree-right-side-view/
Solution: Iterative with BFS, we'll traverse each level of tree using queue and add last element to the output list
Time Complexity: O(N), since one has to visit each node.
Space Complexity: O(D), to keep the queues, where D is a tree diameter
"""

from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right



class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        # base case
        rightside = []
        if not root:
            return rightside

        # in Python the queue implementation with a fast atomic append() and popleft() is deque.
        # add the root to queue
        queue = deque([root, ])

        # iterate over the tree
        while queue:
            # number of elements in the current level
            level_length = len(queue)

            for i in range(level_length):
                # deque has been optimized to do popleft() approximately in O(1), while list.pop(0) takes O(n)
                node = queue.popleft()

                # if its the rightmost element
                if i == level_length - 1:
                    rightside.append(node.val)

                # add child nodes of current level in the queue for the next level
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return rightside
