# Time Complexity : O(N)
#  Space Complexity : O(N)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this :  no

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
        queue =[root]
        ans = []
        while queue:
            len_idx = len(queue)
            current_level = []
            for i in range(len_idx):
                node = queue.pop(0)
                if node is not None:
                    current_level.append(node.val)
                    queue.append(node.left)
                    queue.append(node.right)
            if len(current_level) > 0:
                ans.append(current_level)
        return ans
                
        