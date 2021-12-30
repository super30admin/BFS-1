import collections
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(n) as we're a queue

    def levelOrder(self, root):
        res = []
        q = collections.deque()
        if root:
            q.append(root)

        while len(q):
            # This variable is to keep track of the level
            qLen = len(q)
            level = []
            for _ in range(qLen):
                x = q.popleft()
                level.append(x.val)

                # If left or right child exists, append it to the queue
                if x.left:
                    q.append(x.left)
                if x.right:
                    q.append(x.right)
            res.append(level)

        return res