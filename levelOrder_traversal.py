"""
Time Complexity : O(n)
Space Complexity : O(n)
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
    def levelOrder(self, root):
        result = []
        if not root:
            return []
        
        q = Queue()
        q.put(root)
        
        size = q.qsize()
        while not q.empty():
            size = q.qsize()
            lst = []
            for i in range(size):
                p = q.get()
                lst.append(p.val)
                if p.left:
                    q.put(p.left)
                if p.right: 
                    q.put(p.right)
                    
            result.append(lst)
            
        return result