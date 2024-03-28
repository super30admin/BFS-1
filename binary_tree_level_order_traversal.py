# BFS

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import Optional, TreeNode, deque, List
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        q = deque([root])

        if not root:
            return res

        while q:
            levellist = []
            qsize = len(q)

            for i in range(qsize):
                node = q.popleft()
                levellist.append(node.val)

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

            
            res.append(levellist)
        
        return res
        

#DFS:
# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []

        def helper(root: Optional[TreeNode], level: int):
            if not root:
                return 
            
            if len(result) == level:
                result.append([])
            
            result[level].append(root.val)
            helper(root.left, level+1)
            helper(root.right, level+1)
        
        helper(root, 0)
        return result
        