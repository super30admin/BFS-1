# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        q = collections.deque()
        li = []

        def bfs(root):
            if root:
                q.appendleft(root)
            while q:
                temp = []
                curr = 0
                for _ in range(len(q)):
                    curr = q.pop()
                    temp.append(curr.val)

                    if curr.left: q.appendleft(curr.left)
                    if curr.right: q.appendleft(curr.right)
                li.append(temp)
        bfs(root)
        return li




