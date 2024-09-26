"""
Given the root of a binary tree, return the level order
 traversal of its nodes' values. (i.e., from left to right, level by level).

 time: O(N), N= number of nodes in bi tree
 space: O(N)
"""
import collections
from typing import Optional 
# Definition for a binary tree node.




class Solution:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def levelOrder(self, root: list[int]) -> list[list[int]]:
        #create queue
        queue = collections.deque([root] if root else [])
        ans = []
        while len(queue):
            qlen = len(queue)
            row = []
            for _ in range(qlen):
                curr = queue.popleft()
                row.append(curr.val)
                #if there is left or right child, append to queue
                if curr.left:queue.append(curr.left)
                if curr.right: queue.append(curr.right)
        return ans
obj = Solution()
obj.levelOrder([3,9,20,None,None,15,7])