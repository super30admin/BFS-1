#Time Complexity: O(N)
#Space Complexity: o(h)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.result = []
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        self.dfs(root,0)
        return self.result
    def dfs(self,root,lvl):
        if root is None:
            return
        if len(self.result)==lvl:
            self.result.append([])
        self.result[lvl].append(root.val)
        self.dfs(root.left,lvl+1)
        self.dfs(root.right,lvl+1)