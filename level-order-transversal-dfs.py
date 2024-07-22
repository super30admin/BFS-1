# Time Complexity O(n)
# Space Complexity O(n)
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if root == None: return result

        def dfs(root, level, result):
            if root == None: return

            if len(result) == level:
                result.append([])

            result[level].append(root.val)
            dfs(root.left, level+1, result)
            dfs(root.right, level+1, result)
        dfs(root, 0, result)
        return result
