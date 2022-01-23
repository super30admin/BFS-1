# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from collections import deque
class Solution:
    # Using DFS Solution
    result = list()
    def levelOrder(self, root):
        self.result = []
        if root == None:
            return self.result
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root, level):
        # base case
        if root == None:
            return 
        
        # logic
        if level == len(self.result):
            self.result.append(list())
            
        self.result[level].append(root.val)  
        
        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)

root = TreeNode(3)

root.left = TreeNode(9)

root.right = TreeNode(20)
root.right.left= TreeNode(15)
root.right.right= TreeNode(7)



sol = Solution()
re = sol.levelOrder(root)

print(re)