# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I add root in queue and null element. Then while I encounder not null I pop elements from queue
# and add left and right children of popped element. When I pop null, if len of queue is greater then
# zero I add null. I have used size technique in BFS-2 problem for cousins

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        q = deque()
        if not root: return []
        q.append(root)
        q.append(None)
        results = []
        level = []
        while len(q):
            current = q.popleft()
            if not current:
                results.append(level)
                level=[]
                if len(q):
                    q.append(None)
            else:
                level.append(current.val)
                if current.left:
                    q.append(current.left)
                
                if current.right:
                    q.append(current.right)
                    
        return results