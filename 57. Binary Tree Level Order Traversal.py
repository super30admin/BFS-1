# Time Complexity: O(n)
# Space Complexity: O(n)

# --------------------------------BFS---------------------------------
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None: return
        queue = []
        result = []
        queue.append(root)
        while len(queue) != 0:
            size = len(queue)
            # print(size)
            level = []
            for i in range(size):
                newroot = queue.pop(0)
                level.append(newroot.val)
                if newroot.left != None: 
                    queue.append(newroot.left)
                if newroot.right != None:
                    queue.append(newroot.right)
            # print(level)
            result.append(level)
        return result


# -------------------------------DFS----------------------------------
# class Solution:
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         result = []    
#         self.dfs(root,0,result)
#         return result
    
#     def dfs(self, root, depth, result):
#         #base
#         if root is None: return
        
#         #logic
#         if depth == len(result):
#             result.append([])
#         result[depth].append(root.val)
#         self.dfs(root.left, depth+1, result)
#         self.dfs(root.right, depth+1, result)

        