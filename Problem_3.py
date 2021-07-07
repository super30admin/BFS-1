# Runs on Leetcode
# BFS
    # Runtime - O(n)
    # Memory - O(n)
# DFS
    # Runtime - O(n)
    # Memory - O(1)

# BFS solution

class Solution:
    def rightSideView(self, root):
        if not root:
            return []
        final = []
        queue = [root]
        while queue:
            temp = []
            size = len(queue)
            for _ in range(size):
                popped = queue.pop(0)
                temp.append(popped.val)
                if popped.left:
                    queue.append(popped.left)
                if popped.right:
                    queue.append(popped.right)
            final.append(temp[-1])
        return final
        
# DFS solution

class Solution:
    def rightSideView(self, root):
        if not root:
            return []
        self.final = []
        self.dfs(root,0)
        return self.final
    
    def dfs(self,root,depth):
        # edge case
        if len(self.final) == depth:
            self.final.append(root.val)
        # logic    
        if root.right:
            self.dfs(root.right,depth+1)
        if root.left:
            self.dfs(root.left,depth+1)
