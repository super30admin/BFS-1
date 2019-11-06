# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution:
    
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root == None :
            return []
        
        q1 = deque()
        q2 = deque()
        q1.append(root)
        
        result = []
        while q1 :
            result.append(q1[0].val)
            while q1 :
                e = q1.popleft()
                if e.right :
                    q2.append(e.right)
                if e.left :
                    q2.append(e.left)            
            q1,q2 = q2,q1
        
        return result
