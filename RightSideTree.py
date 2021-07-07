# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root==None:
            return []
        result=[]
        q=Queue()
        q.put(root)
        while(not(q.empty())):
            size=q.qsize()
            last=-1
            for i in range(size):
                curr=q.get()
                last=curr.val
                if curr.left!=None:
                    q.put(curr.left)
                if curr.right!=None:
                    q.put(curr.right)
            result.append(last)
        return result
        
 Time complexity is O(n) as we access all the nodes
 Space complexity is O(n) last level n/2 elements max
