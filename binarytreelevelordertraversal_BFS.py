#Approach : BFS
#Time Complexity : O(n)
#Space Complexity : O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Using BFS
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None: return []
        q = deque()
        q.append(root)
        
        result = []
        while(len(q) != 0):
            size = len(q)
            level = list()
            
            for i in range(size):
                current = q.popleft()
                level.append(current.val)
                
                if(current.left != None): q.append(current.left)
                if(current.right != None): q.append(current.right)
                
            result.append(level)
        return result
