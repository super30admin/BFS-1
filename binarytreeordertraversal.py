from collections import deque 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result=[]
        if root==None:
            return []
        queue=deque()
        queue.append(root)
        while queue:
            size=len(queue)
            templist=[]
            for i in range(0,size):
                temp=queue.popleft()
                templist.append(temp.val)
                if temp.left!=None:
                    queue.append(temp.left)
                if temp.right!=None:
                    queue.append(temp.right)
            result.append(templist)
        return result
            