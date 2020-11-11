# Time:- O(n)
# Space:- O(n)
# Approach:- Do a BFS(using a queue) append nodes to the end of the queue and on encountering -1 check if the queue is empty if it is we are done, if not make a new array 
# and continue with the process
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import collections

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        q=collections.deque([])
        if root is None:
            return []
        q.append(root)
        q.append(-1)
        temp=[]
        res=[]
        while(q):
            node=q.popleft()
            if node==-1:
                res.append(temp)
                if not q:
                    break
                temp=[]
                q.append(-1)
                continue
            temp.append(node.val)
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)
        return res
            
            