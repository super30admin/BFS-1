# Runs on Leetcode
# Runtime - O(n)
# Memory - O(n)

# BFS

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
        
  # DFS
  
  
