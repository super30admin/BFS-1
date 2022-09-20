#tc: O(n)
#sc: O(n)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right 

class Solution:
    def levelOrder(self, root):
        
        if root is None:
            return []
        
        res = []
        q = []
        q.append(root)
        while q:
            size = len(q)
            temp = []
            for i in range(size):
                e = q.pop(0)
                temp.append(e.val)
                if e.left:
                    q.append(e.left)
                if e.right:
                    q.append(e.right)
            res.append(temp)
        return res