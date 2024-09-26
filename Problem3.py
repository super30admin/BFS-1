# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


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

        if root is None:
            return []
        queue = [[root]]
        ans = [root.val]

        while queue:
            lvl = queue.pop(0)
            temp_queue = []
            for node in lvl:
                if node.left is not None and node.right is not None:
                    temp_queue.append(node.left)
                    temp_queue.append(node.right)
                elif node.left is not None:
                    temp_queue.append(node.left)
                elif node.right is not None:
                    temp_queue.append(node.right)
            if len(temp_queue) > 0:
                ans.append(temp_queue[-1].val)
                queue.append(temp_queue)
        return ans