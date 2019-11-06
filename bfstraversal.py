# leetcode: accepted
# no doubts

# you maintain level. If the level is eqUAL TO THE ;EN OF THE LIST, YOU APPEND A NEW LIST AND THE VALUE OF THE ROOT TO THE LIST[0].
# if the level is greater tham the len, the index'th list is already presnent, just append the values


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []  # creating the resultant list
        level = 0  # initalising the lvel has 0
        self.helper(root, level, result)
        return result

    def helper(self, root, level, result):
        if root == None:  # if the root is null return
            return
        if level == len(result):  # if the current level equals the lenght of the result, yu add a new list
            result.append(list())  # adding a list
        result[level].append(root.val)  # appending the value to the result[level]

        self.helper(root.left, level + 1, result)  # recursively caling the left child, and increasing level
        self.helper(root.right, level + 1, result)  # recursively caling the right child and and increasing level