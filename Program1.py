# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Time Complexity - O(n)
#Space Complexity - O(n)

import queue

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        res=[]
        q=queue.Queue()
        
        if root is None:
            return None
        
        q.put(root)
        while not q.empty():
            a=[]
            size=q.qsize()
            
            while size!=0:
                curr=q.get()
                a.append(curr.val)
                if curr.left is not None:
                    q.put(curr.left)
                if curr.right is not None:
                    q.put(curr.right)
                size-=1
                
            if len(a)!=0:
                res.append(a)
        
        return res
            
            