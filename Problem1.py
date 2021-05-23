# time:0(n)
#space:0(n):myq

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
   
    def levelOrder(self, root):
        result = []
        
        if root is None:
            return result
        
       
        
        myq = []
        
        myq.append(root)
        
        while len(myq)!=0:
            s = len(myq)
            level = []
            for i in range(s):
                temp = myq.pop(0)
                level.append(temp.val)
                if temp.left:
                    myq.append(temp.left)
                
                if temp.right:
                    myq.append(temp.right)
            
            result.append(level)
        return result
            
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        