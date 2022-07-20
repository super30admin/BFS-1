# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        l=[]
        def level_order(root,level):
            if root is None:
                return 0
            
            if len(l)==level:
                l.append([])
                
            l[level].append(root.val)
            level_order(root.left,level+1)
            level_order(root.right,level+1)
            
            
        level_order(root,0)
        
        return l