# Using BFS approach

# Time Complexity: O(N)
# Space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = list()
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.result = list()
        if root is None:
            return self.result
         
        queue = list()
        queue.append(root)
        while len(queue) != 0:
            size = len(queue)
            level = list()
            for i in range(size):
                curr = queue.pop(0)
                level.append(curr.val)
                if curr.left != None:
                    queue.append(curr.left)
                if curr.right != None:
                    queue.append(curr.right)
            self.result.append(level)
        return self.result
        


# Using DFS approach

# Time Complexity: O(N)
# Space Complexity: O(h), where h is the height of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = list()
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.result = list()
        if root is None:
            return self.result
        
        self.dfs(root,0)
        return self.result
    
    def dfs(self, root, level):
        if root is None:
            return 0
        
        if level == len(self.result):
            self.result.append([])
        
        self.result[level].append(root.val)
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)