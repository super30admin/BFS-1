# TC = O(n)
# SC = O(n)
# Run on LC

# Definition for a binary tree node.

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        output = []
        level = 0
        if not root:
            return output
        queue = deque([root, ])

        while (queue):

            output.append([])
            ll = len(queue)

            for i in range(ll):
                node = queue.popleft()
                output[level].append(node.val)

                if (node.left):
                    queue.append(node.left)
                if (node.right):
                    queue.append(node.right)

            level += 1

        return output
