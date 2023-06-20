"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

For BFS approach, using a queue to implement FIFO approach, saving the size of queue to determine
number of nodes at each level, before iterating to next level, appending the current level array 
to result.

"""

# Binary tree level order traversal

# Approach - 1
# Using BFS

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return root
        res=[]
        q=deque()
        q.append(root)

        

        while q:
            size=len(q)
            li=[]
            for i in range(size):
                curr=q.popleft()
                li.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(li)
        return res
    

# Approach - 2
# Using DFS

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return root
        res=[]

        def dfs(root,level):
            if not root:
                return
            if level==len(res):
                res.append([])
            res[level].append(root.val)
            dfs(root.left,level+1)
            dfs(root.right,level+1)
        
        dfs(root,0)
        return res

        