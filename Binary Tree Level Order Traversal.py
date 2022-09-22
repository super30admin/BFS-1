# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        def dfs(root,level):
            
            if(root is None):
                return
            if(len(result)<=level-1):
                result.append([root.val])
            else:
                result[level-1].append(root.val)
            
            if(root.left):
                dfs(root.left,level+1)
            if(root.right):
                dfs(root.right,level+1)
            
        result = []
        dfs(root,1)
        
        return result
        
        