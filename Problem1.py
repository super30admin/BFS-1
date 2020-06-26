"""
// Time Complexity : o(n), all nodes in the tree
// Space Complexity : o(n/2) or o(n), maximum nodes at a time in the queue will when processing the leaf nodes
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
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        """
        Level order traversal using BFS
        """
        if not root:
            return None
        
        q = deque()
        
        q.append(root) #adding root to the queue
        
        res = []
        
        while q:
            size = len(q) #size of queue, to keep track of each level
            lvl = [] #keeps all nodes present at a level
        
        for i in range(size): #all nodes at a particular level will be processed at a time
                cur = q.popleft() 
                
                lvl.append(cur.val)
                
                if cur.left:
                    q.append(cur.left)
                
                if cur.right:
                    q.append(cur.right)
            
            res.append(lvl) #adding level to result list
        
        return res
        
        
        
       