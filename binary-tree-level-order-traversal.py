# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #BFS
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        
        #base
        if root == None:
            return result
        
        #initiating q with root
        q = [root]
        
        #print(q)
        
        #logic
        while(q):
            
            #finding size of level
            size = len(q)
            #print(size)
            temp = []
            
            # we traverse the size number of nodes
            for i in range(size):
                curr = q.pop(0)
              #  print(curr.val)
                
                temp.append(curr.val)
             #   print(temp)
                
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
                    
            result.append(temp)
            #print(result)
            
        return result
                
            
                
            

        
        