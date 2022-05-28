#Time complexity: O(n)
#Space complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root):
        if root:
            res=[]
            currl=[]
            currl.append(root)
            while currl:
                nextl=[]
                temp=[]
                while currl:
                    node=currl.pop(0)
                    if node.left:
                        nextl.append(node.left)
                    if node.right:
                        nextl.append(node.right)
                    temp.append(node.val)
                res.append(temp)
                currl=nextl
            return res
        