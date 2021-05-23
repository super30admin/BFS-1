# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if root is None:
            return None
        
        q = list()
        result = []
        q.append(root)
        while q:
            
            queueLength = len(q)
            temp = []
            
            for i in range(queueLength):
                
                popped = q.pop(0)
                temp.append(popped.val)
                if popped.left is not None:
                    q.append(popped.left)
                if popped.right is not None:
                    q.append(popped.right)
            
            
            result.append(temp)
             
        return result
