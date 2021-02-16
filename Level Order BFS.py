# // Time Complexity : O(n)
# // Space Complexity : O(n) -> n/2
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No     - I have a doubt, which DS should I use in python for queue?

# Logic:

# using the queue for storing the nodes at each level. as we go further we pop the node from left 
# add its children to the queue and reapeat until the queue is empty.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if root==None:
            return None
        
        q = deque()
        q.append(root)
        size = 1
        res = []
        while q:
            size = len(q)
            levelRes = []
            for i in range(size):
                x=q.popleft()
                if x.left: q.append(x.left)
                if x.right: q.append(x.right)
                levelRes.append(x.val)
            res.append(levelRes)
        return res