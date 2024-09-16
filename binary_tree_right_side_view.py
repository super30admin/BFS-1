from collections import deque
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []

        output = []
        q = deque()
        q.appendleft(root)
        curr = TreeNode()
        print(curr)
        while len(q)>0:
            length = len(q)
            for i in range(length):
                curr = q.pop()
                if curr.left:
                    q.appendleft(curr.left)
                if curr.right:
                    q.appendleft(curr.right)
            output.append(curr.val) 
        return output
        