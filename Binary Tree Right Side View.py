# Time Complexity : O(N) 
# Space Complexity : O(N)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def rightSideView(self, root):
        if not root:
            return []
        
        self.ans = []
        self.traverse(root,0)
        print(self.ans)
        #return self.ans
    
    def traverse(self,node,level):
        if not node:
            return
        if len(self.ans)<level+1:
            self.ans.append([])
        self.ans[level].append(node.val)
        self.traverse(node.right,level+1)
        self.traverse(node.left,level+1)
    