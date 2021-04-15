# Time Complexity: O(n)
# Space Complexity: O(n)
# Ran on Leetcode: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if not root:
            return res
        q = Queue()
        q.put(root)
        while q.qsize():
            sub = []
            size = q.qsize()
            for i in range(size):
                node = q.get()
                sub.append(node.val)
                if node.left:
                    q.put(node.left)
                if node.right:
                    q.put(node.right)
            res.append(sub)
        return res
        