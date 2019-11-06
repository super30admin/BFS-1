"""
Approach : Dequeue elements from queue1 andadd its children to queue2. 
Swap queues after q1 is empty. continue this process till all nodes are traversed

Time complexity - O(n)
Space complexity - O(n)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root :
            return []
        q1 = deque()
        q2 = deque()
        q1.append(root)
        result = []
        while q1 :
            r = []
            while q1 :
                e = q1.popleft()
                if e.left :
                    q2.append(e.left)
                if e.right :
                    q2.append(e.right)
                r.append(e.val)
            result.append(r)
            q1,q2 = q2,q1
        
        return result
