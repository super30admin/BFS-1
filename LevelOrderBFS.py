#Time Complexity: O(n); traverses all the nodes
#Space Complexity: O(n); n is size of queue

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if root is None:
            return res
        q = deque()
        q.appendleft(root)
        
        while q:
            size = len(q)
            l = []
            for i in range(size):
                temp = q.pop()
                l.append(temp.val)
                if temp.left is not None:
                    q.appendleft(temp.left)
                if temp.right is not None:
                    q.appendleft(temp.right)
            res.append(l)
            
        return res
