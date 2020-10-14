# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        if not root:
            return []
        
        queue=[]
        output=[]
        
        node = root
        
        queue.append(node)
        
        while queue:
            level = len(queue)
            
            for i in range(0,level):
                curr_node = queue.pop(0)
                if i==level-1:
                    output.append(curr_node.val)
                    
                if curr_node.left!=None:
                    queue.append(curr_node.left)
                     
                if curr_node.right!=None:
                    queue.append(curr_node.right)
                    
        return output
                    
                    
                    
            
            
            
        