# Time Complexity :O(n)
# Space Complexity : O(n)
# Any problem you faced while coding this :
# Did this code successfully run on Leetcode : Yes



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        if root is None:
            return None
        res = []
        inter = []
        q = []
        q.append(root)
        while q != [] or len(q) != 0:
            temp = q
            q = []
            inter = []
            while temp != [] or len(temp) != 0:
                tempC = temp.pop(0)
                inter.append(tempC.val)
                if tempC.left is not None:
                    q.append(tempC.left)
                if tempC.right is not None:
                    q.append(tempC.right)
                    
            res.append(inter)
            
        return res