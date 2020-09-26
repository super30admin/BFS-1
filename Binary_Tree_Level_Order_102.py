# Time - O(V+E)   ~ O(n)
# Space - O(no of level * no of elements in the level)  ~ O(n)

# Used basics BFS
# We keep a list of list of nodes and then travest from 1 element in the list and keep adding the children of each element of the list
from collections import deque

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return None
        ans = []
        q = deque()

        q.append(root)

        while q:
            path = []
            level_size = len(q)

            for _ in range(level_size):
                temp = q.popleft()
                path.append(temp.val)

                if temp.left:
                    q.append(temp.left)

                if temp.right:
                    q.append(temp.right)

            ans.append(path)
        return ans
