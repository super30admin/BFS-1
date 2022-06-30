'''
Time Complexity: O(m * n)
Space Complexity: O(m * n)
Run on Leetcode: YES
'''
from collections import deque
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> list[list[int]]:
        if not root:
            return []
        queue = deque()
        queue.append(root)
        result = []
        while len(queue) != 0:
            size = len(queue)
            li = []
            for _ in range(size):
                curr = queue.popleft()
                li.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(li)
        return result