#time-n,space-n
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        q=deque()
        q.append(root)
        res=[]
        while q:
            size=len(q)
            print("s",size)
            for i in range(size):
                
                curr=q.popleft()
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            print(curr.val)    
            res.append(curr.val)
        return res
            