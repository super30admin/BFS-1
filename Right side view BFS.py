# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 

# We use DFS level order,  we store the size at each level, after each level we store the last element into the res array


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        res=[]
        
        q = deque()
        q.append(root)
        
        while q:
            l=[]
            size = len(q)
            for i in range(size):
                x = q.popleft()
                l.append(x.val)
                if x.left : q.append(x.left)
                if x.right: q.append(x.right)
            res.append(x.val)
            
        return (res)
                    