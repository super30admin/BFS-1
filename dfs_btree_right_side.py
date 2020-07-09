# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        ans = []
        if not root:
            return ans
        def dfs(ans, root, height):
            if not root:
                return
            if height == len(ans):
                ans.append(root.val)
            else:
                ans[height] = root.val
            dfs(ans, root.left, height+1)
            dfs(ans, root.right, height+1)
        
        dfs(ans, root, 0)
        return ans

#time complexity - O(n) as every node is traversed

#space complexity - O(1) as no auxillary data structure is used

#all test cases passed