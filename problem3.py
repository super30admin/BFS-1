# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root==None: return None
        level=0
        self.result=[]
        return self.helper(root,level)

   #dfs helper going left side first and increasing level++
   # if level is >= result  new list else updating in the level position  
    def helper(self,root,level):
        #base
        if root==None: return
        #logic
        if level>=len(self.result):
            self.result.append(root.val)
        else:
            self.result[level]=root.val
        
        self.helper(root.left,level+1)
        self.helper(root.right,level+1)
        return self.result