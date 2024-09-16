# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        res = []
        q = deque()
        q.append(root)
        
        while len(q) != 0:
            size = len(q)
            temp = []
            for _ in range(size):
                curr = q.popleft()
                temp.append(curr.val)
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
                    
            res.append(temp)
            
        return res