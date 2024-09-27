# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : - Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def levelOrder(self, root):
        
        self.levels = []
        self.traversal(root, 0)
        return self.levels
    
    def traversal(self, node, level):
        print(level)
        if node:
            if len(self.levels) <= level:
                self.levels += [[node.val]]
            else:
                self.levels[level] += [node.val]
            print(self.levels)
            print(" ")
            self.traversal(node.left, level+1)
            self.traversal(node.right, level+1)