# problem 1

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.result = []
        self.helper(root,0)
        return self.result

    def helper(self,root,depth):
        if not root:
            return 

        if len(self.result) == depth:
            self.result.append([])
        
        self.helper(root.left,depth+1)
        self.result[depth].append(root.val)
        self.helper(root.right,depth+1)