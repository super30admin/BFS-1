# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
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
            cur_size = len(queue)
            while cur_size > 0:
                cur = queue.popleft()
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
                if cur_size == 1:
                    result.append(cur.val)
                cur_size -= 1
        return result
