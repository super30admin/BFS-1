#USING BFS
# TC O(n) and SC O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        q = Queue()
        result = []
        q.put(root)
        while not q.empty():
            size = q.qsize()
            temp = []
            for i in range(size):
                curr = q.get()
                temp.append(curr.val)
                if curr.left != None:
                    q.put(curr.left)
                if curr.right != None:
                    q.put(curr.right)
            result.append(temp)
        return result


#USING DFS
# TC O(n) and SC O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        self.result=[]
        self.dfs(root, 0)
        return self.result

    def dfs(self, root: Optional[TreeNode], level : int) -> None:
        if root == None:
            return
        if level == len(self.result):
            temp = []
            temp.append(root.val)
            self.result.append(temp)
        else:
            self.result[level].append(root.val)
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)