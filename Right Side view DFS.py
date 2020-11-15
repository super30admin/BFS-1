# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 

# We go down in tree using DFS maintaining the level of the each node in recursion
# We check if size of the res array is equal to current level we append the value
# WHY? because if its equal the array has 1 less element in it that the level
# e.g. at 0th level size is 0 so res[0]=val
# at 3rd level size is 3 i.e [1,2,3] so after res[3]=4 it will be [1,2,3,4]


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        res=[]
        
        def dfs(root, level):
            if root:
                if level == len(res):
                    res.append(root.val)
                # else:
                #     res[level] = root.val
                dfs(root.right, level+1)
                dfs(root.left, level+1)
        dfs(root,0)    
        return res
                    
