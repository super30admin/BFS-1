# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        def recur(root, depth):
            nonlocal result
            if not root:
                return
            
            if len(result) == depth: 
                result.append([])
            
            result[depth].append(root.val)
            
            recur(root.left, depth + 1)
            recur(root.right, depth + 1)

        recur(root, 0)
        return result