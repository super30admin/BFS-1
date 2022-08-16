#102. Binary Tree Level Order Traversal
"""
Time Complexity : O(n)
Space Complexity : O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        #null case
        if root == None:
            return []
        
        #logic
        result = []
        
        q = deque()
        q.append(root)
        
        
        while q:
            size = len(q)
            
            temp = []
            
            for i in range(0, size):
                n = q.popleft()
                temp.append(n.val)
                
                if n.left != None:
                    q.append(n.left)
                
                if n.right != None:
                    q.append(n.right)
                    
                
            result.append(temp)
                    
        #print(result)
        return result
         
