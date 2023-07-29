#Time Complexity: O(n)
#Space Complexity: O(h)
#Level order traversal using DFS

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    global output
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return
        self.output=[]
        self.DFS(root,0)
        return self.output

    def DFS(self, root, depth):
        if root is None:
            return
        if depth == len(self.output):
            self.output.append([])
        self.output[depth].append(root.val)
        self.DFS(root.left, depth+1)
        self.DFS(root.right, depth+1)

     



