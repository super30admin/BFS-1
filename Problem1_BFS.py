# Time complexity : O(n)
# Space complexity : O(n) --> max width
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # result is a list of list
        res = []
        
        # if list is null, then return []
        if root is None:
            return res
        
        # start the start with the toor element
        q = deque([root],)
        
        # we traverse until the queue is empty
        while q:
          # maintain the size of the queue, as we need to know the level of the tree to maintain the level order
            size = len(q)
            temp = []
            
            # fetch all the children of the current root node and append them into a temp list
            for i in range(size):
                curr = q.popleft()
                temp.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            # append the temp list, to the final list in level order
            res.append(temp)
        return res
