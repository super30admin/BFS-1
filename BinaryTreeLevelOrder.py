# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time Complexity -->
O(n)

Space Complexity -->
O(n)
'''
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root==None:
            return None
        q = []
        q.append(root)
        res = [[root.val]]
        while q:
            ls1 = []
            ls2 = []
            for i in range(len(q)):
                s = q.pop(0)
                if s.left:
                    ls1.append(s.left)
                    ls2.append(s.left.val)
                if s.right:
                    ls1.append(s.right)
                    ls2.append(s.right.val)
            q = ls1
            if len(ls2)!=0:
                res.append(ls2)
        return res
            
            
            
                
        
        
        