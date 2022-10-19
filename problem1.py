# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def helper(self,root,level):
        if root == None:
            return
        if len(self.result)==level:
            self.result.append([])
        self.result[level].append(root.val)
        self.helper(root.left,level+1)
        self.helper(root.right,level+1)
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        if root.left is None and root.right is None:
            return [[root.val]]
        self.result=[]
        self.helper(root,0)
        return self.result
