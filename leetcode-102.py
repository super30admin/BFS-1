#102. Binary Tree Level Order Traversal
# https://leetcode.com/problems/binary-tree-level-order-traversal/

# T.C: O(n)
# S.C: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
    
        if not root:
            return []

        q = deque([])
        q.append(root)
        res = []
        while q:
            size = len(q)
            curr = []
            for i in range(size):
                item = q.popleft()
                curr.append(item.val)
                if item.left:
                    q.append(item.left)
                if item.right:
                    q.append(item.right)
            
            res.append(curr)
        
        return res