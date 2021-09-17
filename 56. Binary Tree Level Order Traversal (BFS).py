# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []

        result = []

        q = []

        while q:
            li = []
            for i in range(len(q)):
                node = q.pop(0)
                li.append(node.val)

                if node.left:
                    li.append(node.left)
                if node.right:
                    li.append(node.right)

            result.append(li)

        return result
