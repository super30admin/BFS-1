#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
    
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result=[]
        if root==None:
            return result
        q=deque([root])
        while(q):
            qLen=len(q)
            level=[]
            for i in range(qLen):
                curr=q.popleft()
                if curr:
                    level.append(curr.val)
                    if curr.left!=None:
                        q.append(curr.left)
                    if curr.right!=None:
                        q.append(curr.right)
            result.append(level)
        return result

