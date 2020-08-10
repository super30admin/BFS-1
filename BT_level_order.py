# Leetcode 102. Binary Tree Level Order Traversal

# Time Complexity :  O(n) where n is the number of nodes 

# Space Complexity : 
# BFS :: O(n) where n is the number of nodes 
# DFS :: O(H) where H is the height of the tree

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: BFS :: Use a Q to store the current nodes being processed, at every level pop the left most
# node from the queue and add it to the temporary array for that level. Add its child nodes to the Q.
# After every level append the temp array to result and return the result after all the nodes are out of Q.
# DFS :: Using the result and current level being visited, if the size and level match add a new array
# for the level in result. Add the current node's val to the array for the corresponding level

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# BFS
from collections import deque
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        result = []
        q= deque()
        q.append(root)
        
        while q:
            # temp array to collect the nodes at level
            temp = []
                
            for _ in range(len(q)):
                # At every level pop the left most in q and if it has child nodes add them to q
                node = q.popleft()
                temp.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            # After every level append the level nodes to result        
            result.append(temp)
        # When the q is empty return the result
        return result


# DFS
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        if not root:
            return result
        self.__dfs(root,0,result)
        return result
    
    def __dfs(self,node,level,result):
        # Base
        if not node:
            return
        # If the level is visited first time, add a new array to store nodes for that level
        if level == len(result):
            result.append([])
        # Add the current node's value to corresponding level array in result    
        result[level].append(node.val)
        self.__dfs(node.left,level+1,result)
        self.__dfs(node.right,level+1,result)