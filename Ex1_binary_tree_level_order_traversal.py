# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(n), for the queue and result list
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import Optional, List
from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res

        q = deque()
        q.append(root)

        while q:
            level = []
            for _ in range(len(q)):
                node = q.popleft()
                level.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(level)

        return res

# ---------------------------------------------------------------------------
        # DFS-based Recursive Approach 
        # Time Complexity: O(n)
        # Space Complexity: O(h) recursion stack, h is the height of tree

        # res = []
        # def dfs(node, level):
        #     if not node:
        #         return
        #     if level == len(res):
        #         res.append([])
        #     res[level].append(node.val)
        #     dfs(node.left, level + 1)
        #     dfs(node.right, level + 1)

        # dfs(root, 0)
        # return res
