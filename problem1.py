#Time Complexity O(N)
#Space Complexity O(H) height of list
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if root == None:
            return result
        
        q = []
        q.append(root)
        
        while len(q)>0:
            #To know how many elements to be processed
            size = len(q)
            temp = []
            for x in range(size):
                curr = q.pop(0)
                temp.append(curr.val)
                if curr.left !=None:
                    q.append(curr.left)
                if curr.right !=None:
                    q.append(curr.right)
                
            result.append(temp)
        return result
                
            
            
        
