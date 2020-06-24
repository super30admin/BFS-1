#102. Binary Tree Level Order Traversal
# Time Complexity : O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        self.result = []
        self.dfs(root,0)
        return self.result
    def dfs(self,root,level):
        if not root:
            return
        
        if level == len(self.result):
            self.result.append([])
        self.result[level].append(root.val)
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)