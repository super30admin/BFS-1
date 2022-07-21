# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.l= []
        height = 0
        self.traverse(root, height)
        return self.l
    def traverse(self,root,height):
        if(root == None):
            return
        if(len(self.l)<=height):
            self.l.append([])
        self.l[height].append(root.val)
        self.traverse(root.left, height+1)
        self.traverse(root.right, height+1)
        