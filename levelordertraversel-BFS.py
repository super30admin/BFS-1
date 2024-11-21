"Time Complexity is O(N)"
"Space Complexity is O(N)"

from collections import deque
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
        queue = deque([root])

        while queue:
            lensize = len(queue)
            current_nodes = []

            for _ in range(lensize):
                node = queue.popleft()
                current_nodes.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            result.append(current_nodes)

        return result
        