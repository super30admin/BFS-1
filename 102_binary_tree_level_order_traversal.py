# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        """
            https://leetcode.com/problems/binary-tree-level-order-traversal/
                // Time Complexity : O(n)
                // Space Complexity : O(n)
                // Did this code successfully run on Leetcode : Yes
                // Any problem you faced while coding this : No
                // Three line explanation of solution in plain english :
                    - Normal level order
                    - To add elements by each level, keep track using the
                      size of the of the deque.
        """

        # edge case
        if not root:
            return []

        queue = deque()
        queue.append(root)
        result = []

        while queue:
            cur_size = len(queue)
            cur_result = []
            while cur_size > 0:
                cur = queue.popleft()
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
                cur_result.append(cur.val)
                cur_size -= 1
            result.append(cur_result)
        return result
