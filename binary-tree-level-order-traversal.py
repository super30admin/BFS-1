"""
Time - O(n)
Space - O(n)
Runs on leetcode - YES
"""
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        
        q = deque()
        res = []
        q.append(root)
        
        while q:
            size = len(q)
            level = []
            for _ in range(size):
                node = q.popleft()
                level.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(level)
        
        return res