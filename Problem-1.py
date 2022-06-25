# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        output=[]
        
        #null check
        if not root:
            return output
        
        #BFS
        q=[]
        q.append(root)
        
        while q:
            count=len(q)
            level=[]
            for i in range(count):
                node=q.pop(0)                
            #process children
                if node.left is not None:
                    q.append(node.left)                
                if node.right is not None:
                    q.append(node.right)
                level.append(node.val)
                    
            output.append(level)
                
        return output