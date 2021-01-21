# Created by Aashish Adhikari at 6:13 PM 1/20/2021

'''
Time Complexity:
O(n)

Space Complexity:
Ignoring recursive stack, O(1)
If not, O(h) since we store a maximum of h items in the recursive stack at any given time.


'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def helper(self, node, level):



        # logic
        if level+1 > len(self.sol):
            self.sol.append([])

        self.sol[level].append(node.val)

        if node.left is not None:
            self.helper(node.left, level+1)

        if node.right is not None:
            self.helper(node.right, level+1)


    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return []

        self.sol = []

        self.helper(root, 0)

        return self.sol

