# Leetcode 102: Binary Tree Level Order Traversal

# Method DFS
# Time - O(n)
# Space - O(n)
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
#         index 0 -> level 1
        result = []
        
        def dfs(root, level):
            
            if root is None:
                return
            
            if level > len(result):
                temp = [root.val]
                result.append(temp) 
            else:
                result[level - 1].append(root.val)
            
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
        
        dfs(root, 1)
        
        return result
        