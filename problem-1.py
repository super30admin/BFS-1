# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes

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
        if not root:
            return []
        result = []
        queue = deque()
        
        #BFS
        queue.append(root)
        
        while(queue):
            size = len(queue)
            currLevel = []
            
            for i in range(0, size):
                curr = queue.popleft()
                if(curr):
                    currLevel.append(curr.val)

                    if(curr.left):
                        queue.append(curr.left)
                    if(curr.right):
                        queue.append(curr.right)
                
            if len(currLevel) > 0:
                result.append(currLevel)
            
        return result