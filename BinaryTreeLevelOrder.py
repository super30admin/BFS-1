# Time Complexity: O(n)
# Space Complexity: O(n)
# Does this code run on Leetcode: Yes
# Did you face any problem while coding this: No

from collections import deque
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        q = deque()
        result = []
        if root is None:
            return result
        q.append(root)
        while len(q)!= 0:
            size = len(q)
            temp = []
            for i in range(size):
                curr = q.popleft()
                temp.append(curr.val)

                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
            result.append(temp)
        return result
    
# DFS APproach
# Time Complexity: O(n)
# Space Complexity: O(h)
# Did you face any problem while coding this: No
# Does this code run on Leetcode: Yes
  
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def __init__(self):
        self.result = []
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return self.result
        self.helper(root, 0)
        return self.result
    def helper(self, root, level):
        if root is None:
            return self.result
        
        if len(self.result) == level:
           self.result.append([])
        self.result[level].append(root.val)
        self.helper(root.left, level+1)
        self.helper(root.right,level+1)
        

        