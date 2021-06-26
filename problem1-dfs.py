# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        result = []
        
        def dfs(root, level):
            if root == None:
                return
            size = len(result)
            if level == size:
                result.append([root.val])
            if level < size:
                result[level].append(root.val)
            
            dfs(root.left, level+1)
            dfs(root.right, level+1)
            
        dfs(root,0)
        return result
#Time complexity is O(n) as using lists for stack and removing the first element raises the complexity
#Space complexity is O(n) worst case will have all the child nodes in the stack
#DFS used to store all the nodes in the result list at each level