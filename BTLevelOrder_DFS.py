# TC: O(N) since we are processing all the nodes
# SC: O(H) where H is the size of the recursive stack.

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        self.final = []
        if not root:
            return 
        
        def dfs(root, level):
            if not root:
                return
            if level == len(self.final):
                self.final.append([])
            
            self.final[level].append(root.val)
            
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
            
        dfs(root, 0)
        return self.final
