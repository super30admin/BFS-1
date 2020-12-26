# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity - O(n)
# Space Complexity - O(n)
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        rightsideView = []
        queue = [root]
        temp = 0
        while queue:
            l = len(queue)
            for _ in range(l):
                curr = queue.pop(0)
                temp = curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            rightsideView.append(temp)
        return rightsideView

