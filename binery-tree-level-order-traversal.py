# Time Complexity :O(n)
# Space Complexity : O(n) using deque
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        q=collections.deque()
        res=[]
        
        q.append(root)
        
        while q:
            qlen=len(q)
            limit=[]
            
            for i in range(qlen):
                node=q.popleft()
                
                if node:
                    limit.append(node.val)
                    q.append(node.left)
                    q.append(node.right)
            if limit:
                res.append(limit)
            
        return (res)