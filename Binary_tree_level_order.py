# TC: O(N)
# SC: O(logN)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
  res=[]
  def helper(self,root,level):
    if root==None:
      return 
    
    if len(self.res)<=level:
      self.res.append([])
    self.res[level].append(root.val)
    if root.left:
      self.helper(root.left,level+1)
    if root.right:
      self.helper(root.right,level+1)


  def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
    self.res=[]
    self.helper(root,0)
    print(self.res)
    return self.res
        