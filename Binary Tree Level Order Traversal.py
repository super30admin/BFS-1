# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result=[]
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root==None:return result
        q=[]
        q.append(root)
        while(len(q)!=0):
            size=len(q)
            li=[]
            for i in range(size):
                curr=q.poll()
                li.append(curr.val)
                if(curr.left!=None):
                    q.append(curr.left)
                if(curr.right!=None):
                    q.append(curr.right)
                self.result.append(li)
        return self.result