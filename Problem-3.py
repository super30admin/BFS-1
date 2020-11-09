class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:

        res=[]

        if not root:
            return res

        q=collections.deque()
        q.append(root)
        while q:
            size = len(q)
            for i in range(size):
                node = q.popleft()
                if i == size-1:
                    res.append(node.val)

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

        return res
