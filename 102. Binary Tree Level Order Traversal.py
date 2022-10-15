# BFS using queue:
# TC - O(n)
# SC - O(n)

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        
        res = []
        q = deque([root])
       
        
        #BFS
        while q:
            lvl = []
            for i in range(len(q)):
                node = q.popleft()
                lvl.append(node.val)
                # add children to q
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(lvl)
        return res

# DFS - recursive
# TC - O(n)
# SC - O(n)
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        
        res = []
        def dfs(root,depth):
            #base
            if root == None:
                return
            #logic
            if depth == len(res):
                res.append([])
            res[depth].append(root.val)
            
            dfs(root.left, depth+1)
            dfs(root.right, depth+1)
        dfs(root,0)
        return res
        
        