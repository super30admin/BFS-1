# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


import collections
class Solution:
    def levelOrder(self, root):
        res = []
        
        # queue to store nodes
        q = collections.deque()
        q.append(root)
        
        while q:
            
            # get number of nodes currently in q
            qlen = len(q) 
            level = []
            
            # loops one level at a time
            for i in range(qlen):
                node = q.popleft()
                if node:
                    level.append(node.val) # appends nodes by level
                    q.append(node.left)
                    q.append(node.right)
                    
            # list of level nodes
            if level:
                res.append(level)
                    
        return res