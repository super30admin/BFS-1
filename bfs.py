'''
Time Complexity: O(N)
Space Complexity: O(h) 
'''
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
        op = []
        def preorder(level, root):
            
            if(not root):
                return op
            if(level <= len(op)-1):
                op[level].append(root.val)
            else:
                op.append([root.val])
            preorder(level+1,  root.left)
            preorder(level+1,  root.right)
        preorder(0, root)
        return op
        