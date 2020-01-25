# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Solution:
    def rightSideViewBFS(self, root: TreeNode) -> List[int]:
        """
            https://leetcode.com/problems/binary-tree-right-side-view/
            // Time Complexity : O(n)
                'n' is the number of nodes
            // Space Complexity : O(n)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                    - Level order traversal
                    - For each level in the tree add the right most element
        """
        result = []
        if not root:
            return result
        # level order traversal
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            for i in range(size):
                cur = queue.popleft()
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
                if i == size - 1:
                    result.append(cur.val)
        return result

    def rightSideViewDFS(self, root: TreeNode) -> List[int]:
        """
            https://leetcode.com/problems/binary-tree-right-side-view/
            // Time Complexity : O(n)
                'n' is the number of nodes
            // Space Complexity : O(h)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                    - DFS and maintain a result list and depth
                    - If the depth is equal to the size of list,
                        add the element to the result list
                    - If the depth == size of the result list,
                        element is not added, add the element
        """

        result = []
        if not root: return result

        self._helper(root, 0, result)
        return result

    def _helper(self, root, depth, result):

        # base
        if root is None: return

        # logic
        if depth == len(result):
            result.append(root.val)
        # right sub tree
        self._helper(root.right, depth + 1, result)
        # left sub tree
        self._helper(root.left, depth + 1, result)
