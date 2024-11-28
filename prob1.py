# Time Complexity : O(N) for while loop
# Space Complexity : O(H) for recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# using dfs approach, for every level, 
# if length of result array == level, 
# that means there is no nested array for this level,
# so append a list to the result array, 
# else just add the element to the nested array in result   
# array whose index is level


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val 
        self.left = left
        self.right = right


class Solution:

    result = []
    def levelOrder(self, root):
        global result
        result = []
        if root is None:
            return result
        self.dfs(root, 0)
        return result

    def dfs(self, root, level):
        if root is None:
            return 
        if len(result) == level:
            result.append([])
        result[level].append(root.val) 

        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)
    