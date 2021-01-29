#time: O(n)
#space: O(h)

#Dfs
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result=[]
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        self.result=[]
        if(root==None):
            return []
        self.result.append([root.val])
        self.helper(root.left,1)
        self.helper(root.right,1)
        return self.result
    
    def helper(self,root,level):
        if root==None:
            return
        if len(self.result)>level:
            self.result[level].append(root.val)
        else:
            self.result.append([root.val])
        self.helper(root.left,level+1)
        self.helper(root.right,level+1)
        