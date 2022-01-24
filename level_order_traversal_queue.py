# Definition for a binary tree node.

# SC : O(n)
# TC :O(n)

from typing import Optional
from pip import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue = []
        if root:
            queue.append(root)
        res =[]
        while queue:
            qlen = len(queue)
            temp_arr = []
            for i in range(qlen):
                node = queue.pop(0)
                temp_arr.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            res.append(temp_arr)
        return res
            
            