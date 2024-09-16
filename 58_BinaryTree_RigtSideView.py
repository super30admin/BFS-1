# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        # edge case
        if not root: return None
        queue = []
        queue.append(root)
        while queue:
            size = len(queue)
            temp = None
            for i in range(size):
                curr = queue.pop(0)
                temp = curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(temp)
# aas always the rightmost element is processed at the end, use a variable temp to capture it.
#  and append it to result everytime we exit for loop(for loop will run for each level)
        return result