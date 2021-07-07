# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue 
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root==None:
            return []
        result=[]
        q=Queue()
        q.put(root)
        while(not(q.empty())):
            temp=[]
            size=q.qsize()
            for i in range(size):
                curr=q.get()
                temp.append(curr.val)
                if curr.left!=None:
                    q.put(curr.left)
                if curr.right!=None:
                    q.put(curr.right)
            result.append(temp)
        return result
        
 Time complexity is O(n) as we traverse all the nodes
 Space complexity is O(n) as we n/2 elements at the last level
