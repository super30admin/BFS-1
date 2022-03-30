# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result=[]
        if not root:
            return result
        def helper(root, count):
           
            if len(result) == count:
                result.append([])
                
            result[count].append(root.val)
                
            if root.left:
                helper(root.left, count+1)
            if root.right:
                helper(root.right, count+1)
            
        helper(root, 0)
        return (result)
