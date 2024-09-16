# Time Complexity : Add - O(n)
# Space Complexity :O(2^h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I am using BFS and adding the last node of each level into global list
'''

from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        if root is None:
            return
        
        result = []
        queue = deque()
        queue.append(root)
        
        while queue:
            
            size = len(queue)
            while size > 0:
                
                root = queue.popleft()
                if root.left:
                    queue.append(root.left)
                if root.right:
                    queue.append(root.right)
            
                size -= 1
                
            result.append(root.val)
        
        return result