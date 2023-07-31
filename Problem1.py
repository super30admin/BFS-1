# Time Complexity: O(n)
# Space Complexity: O(n)


class Solution:
    def __init__(self):
        self.res = []
        self.q = collections.deque()

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        self.q.append(root)
        self.queue()

        return self.res

    def queue(self):
        while self.q:
            length = len(self.q)
            level = []
            for i in range(length):
                node = self.q.popleft()
                level.append(node.val)
                if node.left:
                    self.q.append(node.left)
                if node.right:
                    self.q.append(node.right)
            self.res.append(level)
