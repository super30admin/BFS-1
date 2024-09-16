# Accepted on leetcode(199)
# time - O(N), space - O(N)
# 1. take a variable depth and calculate the depth as we are traversing the tree.
# 2. Then compare the depth with length of result array
# 3. if the length of result array is equal to depth then add the value of node to the result array.
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        self.helper(root, result, 0)
        return result

    def helper(self, root, result, depth):
        # edge case
        if not root: return None
        # base case
        if depth == len(result):  # comparing depth with len(result)
            result.append(root.val)  # append value of root to result
        self.helper(root.right, result, depth + 1)  # traverse right first, to see the right side of tree
        self.helper(root.left, result, depth + 1)  # traverse left side
