# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        q=[]
        res=[]
        if not root:
            return root
        
        q.append(root)
        while len(q)!=0:
            temp1=[]
            size= len(q)
            for i in range(0,size):
              temp = q.pop(0)
              temp1.append(temp.val)
              if temp.left:
                  q.append(temp.left)
              if temp.right:
                  q.append(temp.right)

            res.append(temp1)

        return res
        