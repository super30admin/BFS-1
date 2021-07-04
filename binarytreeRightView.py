# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root) :
        result = []
        if root is None:
            return result
        queue = deque()
        queue.append(root)  # store elements visited in each level

        while queue:
            last_node = None  # last node at each level
            for i in range(len(queue)):
                node = queue.popleft()
                last_node = node

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            result.append(last_node.val)  # append the last node to the result

        return result
