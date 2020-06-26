"""
// Time Complexity : o(n), n-> number of nodes
// Space Complexity : o(n/2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return None
        q = deque()
        
        q.append(root)
        visible = []
        #visible.append(root.val)
        
        while q:
            size = len(q)
           
            for i in range(size): #iterating over nodes at a particular level
                cur = q.popleft()
                
                if i == size-1: #right most node
                    visible.append(cur.val) #add to result
                
                if cur.left:
                    q.append(cur.left)
                
                if cur.right:
                    q.append(cur.right)
            
            #size=len(q)
            #if len(q)>0:
             #   visible.append(q[-1].val)
        return visible