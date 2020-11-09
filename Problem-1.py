class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res=[]
        q = collections.deque()
        if not root:
            return res
        q.append(root)
        while q:
            cur=[]
            size = len(q)
            for _ in range(size):
                node = q.popleft()
                cur.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

            res.append(cur)

        return res
