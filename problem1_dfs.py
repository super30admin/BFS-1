"""
Time Complexity : O(n) where n is the total number of tree nodes.
Space Complexity : O(h) where h is the height of the tree. At max, the recursive stack will contain elements equal to the height of the tree

Did this code successfully run on Leetcode : Yes

Your code here along with comments explaining your approach:
Maintain a depth of the tree.
At every depth create a new list and append it to the result list.
When trying to add elements, access the list assigned to that particular depth and add element to that list.
Recursively visit all the nodes of the trees and everytime making a recusrive call increase depth by 1 as child will alwasys be at 1 step ahead of root and the recursive call will always be made from root.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
    
    def dfs(self, root, depth):
        #base
        if root == None:
            return
        
        #Logic
        if depth == len(self.result):
            self.result.append([])
        self.result[depth].append(root.val)
        
        self.dfs(root.left, depth+1)
        self.dfs(root.right,depth+1)
        
        
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return self.result
        self.dfs(root, 0)
        return self.result
        
        