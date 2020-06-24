#199. Binary Tree Right Side View
# Time Complexity : O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#traversing from left to right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        self.result = []
        self.dfs(root,0)
        return self.result
    def dfs(self,root,level):
        if not root:
            return
        if len(self.result) == level:
            self.result.append(root.val)
        self.result[level] = root.val
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)
#traversing from right to left	
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        self.result = []
        self.dfs(root,0)
        return self.result
    def dfs(self,root,level):
        if not root:
            return
        if len(self.result) == level:
            self.result.append(root.val)
        #self.result[level] = root.val
        self.dfs(root.right,level+1)
        self.dfs(root.left,level+1)