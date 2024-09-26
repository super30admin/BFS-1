# Leetcode 199. Binary Tree Right Side View

# Time Complexity :  O(n) where n is the number of the nodes

# Space Complexity :
# BFS:: O(n/2) == O(n) where n is the number of the nodes that can be in the q at worst
# DFS :: O(h) where h is the height of the tree

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: DFS :: at every node if the current level matches the size of the result array, add the node
# to result. Increment the level by 1 and call dfs recursively on left and right node.
# BFS:: add the root to que, at every level append the last node to the result. If the left or 
# right child are present add them to the q. return result after q is empty 

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# DFS approach :: Traversing the tree recursively starting with the right sub tree first at every level
class Solution:
    result = None
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.result = []
        if not root:
            return self.result
        self.dfs(root,0)
        return self.result
    
    def dfs(self,node,level):
        if not node:
            return
        # Updating rightSide view when the current level matches the size of the view array
        if level == len(self.result):
            self.result.append(node.val)
        # Traversing next level starting with right subtree    
        self.dfs(node.right,level+1)
        self.dfs(node.left,level+1)


# BFS approach
from collections import deque
class Solution:
    result = None
    def rightSideView(self, root: TreeNode) -> List[int]:
        q = deque()
        q.append(root)
        result = []
        while q:
            size = len(q)
            # At every level append the last node to the result
            for i in range(len(q)):
                node = q.popleft()
                if i == size-1:
                    result.append(node.val)
                # If the left or right child are present add them to the q
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        # return result after q is empty 
        return result