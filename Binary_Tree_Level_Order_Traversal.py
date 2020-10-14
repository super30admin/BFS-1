# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:


        
        if not root:
            return []
        
        queue=[]
        output=[]
        
        node = root
        
        queue.append(node)
        
        while queue:
            length = len(queue)
            level = []
            
            for i in range(0,length):
                curr_node = queue.pop(0)
                
                level.append(curr_node.val)
                    
                if curr_node.left!=None:
                    queue.append(curr_node.left)
                     
                if curr_node.right!=None:
                    queue.append(curr_node.right)
            output.append(level)
                    
        return output
    
    

                    
                    
                    
            
            
            
        
        