# time: O(n)
# space: O(n/2)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        q = [root]
        res = []
        
        if root is None:
            return []
        while q:
            li = []
            size = len(q)
            for i in range(size):
                popped = q.pop(0)
                li.append(popped.val)
                if popped.left:
                    q.append(popped.left)
                if popped.right:
                    q.append(popped.right)
            res.append(li)
        return res