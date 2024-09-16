# Accepted on leetcode(102)
# time - O(N), space - O(2^H)
# Breadth first search is used to find and traverse all the elements in level order.
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []  # final result array
        # edge case
        if not root: return None
        queue = []  # Queue datastructure, in python the list is used.
        queue.append(root)
        while queue:  # while queue is not empty
            temp = []  # append all elements in that level to temp as an inner list.
            size = len(queue)
            for i in range(size):  # to traverse all elements in that level.
                curr = queue.pop(0)
                temp.append(curr.val)
                if curr.left: queue.append(curr.left)  # check for left child
                if curr.right: queue.append(curr.right)  # check for right child

            result.append(temp)

        return result