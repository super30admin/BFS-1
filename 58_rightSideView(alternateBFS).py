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
            # traverse the right subtree first and append the peek element in the queue
            result.append(queue[0].val)
            for i in range(size):
                curr = queue.pop(0)
                if curr.right:
                    queue.append(curr.right)
                if curr.left:
                    queue.append(curr.left)

        return result