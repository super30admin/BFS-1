# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#saving in the array format based on the depth of the node
class Solution:
    def __init__(self):
        self.arr = []
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        self.helper(root,0)
        return self.arr
    
    def helper(self,root,level):
        if root == None:
            return;
        if level + 1 > len(self.arr):
            self.arr.append([])
        self.arr[level].append(root.val)
        self.helper(root.left,level+1)
        self.helper(root.right,level+1)
        