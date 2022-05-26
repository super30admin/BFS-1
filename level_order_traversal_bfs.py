# Time Complexity : O(N) where N is number of nodes in the birnary tree
# Space Complexity : O(N) where N is number of nodes in the birnary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque 
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None: return []
        
        q = deque()
        result = []
        q.append(root)
                
        while len(q) != 0:
            size = len(q)
            i = 0
            temp = []
            while i < size:
                i += 1
                node = q.pop()
                temp.append(node.val)
                if node.left is not None:
                    q.appendleft(node.left)
                if node.right is not None:
                    q.appendleft(node.right)
            
            result.append(temp)
            
        return result
                    
                