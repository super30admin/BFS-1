# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

from collections import deque

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        q = deque()
        
        if root:
            q.append(root)
        
        levels = []
        while len(q) != 0:
            
            level = []
            level_q = len(q)
            
            for i in range(level_q):
                
                temp = q.popleft()
                if(temp.left):
                    q.append(temp.left)
                if(temp.right):
                    q.append(temp.right)
                    
                level.append(temp.val)
                
            
            levels.append(level)
        
        return levels