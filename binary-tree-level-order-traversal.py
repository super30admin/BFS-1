# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC: O(n)
#SC: O(h)
class Solution:
    def levelOrder(self, root):
        if not root:
            return root
        res = []
        q = deque()
        q.append(root)
        while q:
            s = len(q)
            temp = []
            for i in range(s):
                curr = q.popleft()
                if curr:
                    temp.append(curr.val)
                    if curr.left:
                        q.append(curr.left)
                    if curr.right:
                        q.append(curr.right)
            res.append(temp)

        return res
    
