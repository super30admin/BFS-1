
# Time- O(n)
# Space -O(n)
from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None:
            return None
        ans = []
        
        q =deque()
        
        q.append(root)

        while q:
            
            level_size = len(q)
            
            for _ in range(level_size):
                curr = q.popleft()
                temp = curr.val                
                if curr.left:
                    q.append(curr.left)                    
                if curr.right:
                    q.append(curr.right)
            ans.append(temp)
            
        return ans