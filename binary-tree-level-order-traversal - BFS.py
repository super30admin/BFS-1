# Time complexity: O(n) where n is the number of nodes
# Space complexity: O(n)

# The code successfully ran on Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
        
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None: return self.result
        
        q = []
        q.append(root)
        
        while q:
            size = len(q)
            l = []
            
            for i in range(size):
                curr = q.pop(0)
                l.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                
            self.result.append(l)
            
        return self.result
                
        