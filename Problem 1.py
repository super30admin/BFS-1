# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time:O(n)
# Space: O(1)
class Solution(object):
    def __init__(self):
        self.arr = []
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root == None:
            return []
        self.height(root, 0)
        return self.arr
    def height(self, root, height):
        if height == len(self.arr):
            self.arr.append([root.val])
        else:
            self.arr[height].append(root.val)
        if root.left != None:
            self.height(root.left, height+1)
        if root.right != None:
            self.height(root.right, height+1)
        return None
        
