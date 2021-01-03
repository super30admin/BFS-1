"""
Time complexity O(N/2)
Space O(1)

-Select only one node at each level and that is right node
-Append to res when len(res)==level
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_rightSideView:
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.res=[]
        self.rightSideViewutil(root,0)
        return self.res
    def rightSideViewutil(self, root,level):
        if root is None:
            return 
        
        if (len(self.res)==level):
            self.res.append(root.val)
        
        self.rightSideViewutil(root.right,level+1)
        self.rightSideViewutil(root.left,level+1)
        
        