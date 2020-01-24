"""
Time Complexity : rightSideView_BFS() - O(n)
                  rightSideView_DFS() - O(n)
Space Complexity : rightSideView_BFS() - O(n)
                   rightSideView_DFS() - O(1) [O(max depth) stack space]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

from queue import Queue

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    res = [] # for DFS solution
    
    def rightSideView_BFS(self, root):
        res = []
        if not root:
            return res
        
        q = Queue()
        q.put(root)
        
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                p = q.get()
                if p.left: 
                    q.put(p.left)
                if p.right:
                    q.put(p.right)
                    
            res.append(p.val)
        return res
    
    def rightSideView_DFS(self, root):
        self.res.clear()
        if not root:
            return self.res
        
        self.helper(root, 0)
        return self.res
    
    def helper(self, root, depth):
        # base case
        if not root:
            return
        
        # recursive case
        if depth == len(self.res):
            self.res.append(root.val)
        self.helper(root.right, depth+1)
        self.helper(root.left, depth+1)
                    