#Time complexity: O(n)
#Space complexity: O(n)

#Accepted on Leetcode

#Approach:
#Maintain a queue for BFS
#At the start of each 'level' take the size variable to successfully traverse only that level (add the children of each nodes in a 'level' to the queue)
#Thus this way we know the start and end of a given level

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    soln = []
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.soln = []
        self.dfs(root, 0)
        return self.soln
    
    def dfs(self, root, level):
        if root == None:
            return
        
        if level == len(self.soln):
            self.soln.append([])
        self.soln[level].append(root.val)
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)
        

