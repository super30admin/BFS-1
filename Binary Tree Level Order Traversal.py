#TC: O(n)
#SC: O(n)
from collections import deque 

class Solution:
    
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []  # Define result as a local variable
        if root is None:
            return result
        
        # BFS
        q = deque()
        q.append(root)

        while q:
            size = len(q)
            level_values = []
            for i in range(size):
                curr = q.popleft()
                level_values.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            result.append(level_values)

        return result
