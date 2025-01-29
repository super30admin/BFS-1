"""
Problem Statement: Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
TC: O(N)
SC: O(N)
Approach: BFS
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        if not root:
            return []

        result = []
        queue = [root]

        while queue:
            size = len(queue)
            answer = []

            for i in range(size):
                node = queue.pop(0)
                answer.append(node.val)
                if node.left:
                    queue.append(node.left)

                if node.right:
                    queue.append(node.right)

            result.append(answer)

        return result

