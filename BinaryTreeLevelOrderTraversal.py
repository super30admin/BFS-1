'''
TC: O(n) where n is number of nodes
SC: O(1)
'''
# Definition for a binary tree node.
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.res = []

        def helper(root, level):
            if not root:
                return
            if len(self.res) == level:
                self.res.append([])
            self.res[level].append(root.val)
            helper(root.left, level+1)
            helper(root.right, level+1)

        helper(root, 0)
        return self.res