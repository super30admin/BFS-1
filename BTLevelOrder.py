'''
    Time Complexity:
        O(n)

    Space Complexity:
        O(n)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        BFS Fashion
'''
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if not root:
            return res

        q = collections.deque()
        q.append(root)

        while q:
            nodes = len(q)
            i = 0
            level = []

            while i < nodes:
                node = q.popleft()
                level.append(node.val)

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

                i += 1

            res.append(level)

        return res
