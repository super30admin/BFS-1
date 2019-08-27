# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :



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
        if root is None:
            return []

        stack = [[root]]
        ans = [[root.val]]
        while len(stack) != 0:
            lvl = stack.pop(0)
            temp = []
            tmp_stack = []
            for node in lvl:
                if node.left is not None and node.right is not None:
                    tmp_stack.append(node.left)
                    tmp_stack.append(node.right)
                    temp.append(node.left.val)
                    temp.append(node.right.val)
                elif node.left is not None:
                    tmp_stack.append(node.left)
                    temp.append(node.left.val)
                elif node.right is not None:
                    tmp_stack.append(node.right)
                    temp.append(node.right.val)
            if len(temp) > 0:
                ans.append(temp)
                stack.append(tmp_stack)
        return ans

# This is an iterative solution in which I used a Queue. I lopped till the queue was empty and then found all the nodes
# at the same level and inserted in the final list and the queue.