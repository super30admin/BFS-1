# Time Complexity : O(n)
# Space Complexity : O(n)  (Space should be O(n/2) as that will be the width of the tree)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# BFS
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
            
            result = []
            if not root:
                return
            q = deque()
            q.append(root)
            
            def bfs(root):
                while q:
                    arr = []
                    for i in range(len(q)):
                        node = q.popleft()
                        arr.append(node.val)

                        if node.left:
                            q.append(node.left)
                        if node.right:
                            q.append(node.right)
                            
                    result.append(arr)
                
            bfs(root)
            return result
            
            
#   DFS
# Time complexity: O(n)
# Time compelxity: O(h)  h is the depth of tree
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if root is None:
            return res
        self.dfs(root, 0, res)
        return res
        
    def dfs(self, root, depth, res):
#       base  
        if root is None:
            return
#       logic
        if depth == len(res):
            res.append([])
                
        res[depth].append(root.val)
        self.dfs(root.left, depth + 1, res)
        self.dfs(root.right, depth + 1, res)
            
            
            
