# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity - O(n)
# Space complexity - O(n)
# BFS colution
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        queue = deque()
        queue.append(root)
        result = []
        while queue:
            res = []
            for _ in range(len(queue)):
                node = queue.popleft()
                res.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.append(res)
        return result


# Time complexity - O(n)
# Space complexity - O(h)
# DFS 
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        result = []
        def helper(root, level):
            if not root: return
            if len(result) == level:
                res = []
                result.append(res)
            result[level].append(root.val)
            helper(root.left, level+1)
            helper(root.right, level+1)
        helper(root,0)
        return result







