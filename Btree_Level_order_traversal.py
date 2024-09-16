from collections import deque
class Solution:
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        result = []

        q = deque()
        q.appendleft(root)

        while len(q) > 0:
            new_level = []
            len_q = len(q)
            for i in range(0, len_q):
                current = q.pop()
                if current.left:
                    q.appendleft(current.left)
                if current.right:
                    q.appendleft(current.right)
                new_level.append(current.val)
            result.append(new_level)
        
        return result