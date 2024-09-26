

# 199. Binary Tree Right Side View

# Approach: General BFS, append only the last node from each level


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import collections
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        res= []
        
        if not root:
            return []
        
        q= collections.deque()
        
        q.append(root)
        
        while q:
            local = []
            
            for _ in range(len(q)):
                curr = q.popleft()
                local.append(curr.val)
                
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(local[-1])
        
        return res


# Time Complexity: O(V+E)
# Space Complexity: O(V+E)
# Accepted on Leetcode: Yes.