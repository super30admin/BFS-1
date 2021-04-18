# Time Complexity : O(n), where n is the number of nodes
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return root

        result = []

        level = 0
        q = [root]

        while q:
            if level == len(result):
                temp = []

            size = len(q)

            for i in range(size):
                node = q.pop(0)
                temp.append(node.val)

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

            level += 1
            result.append(temp)

        return result
