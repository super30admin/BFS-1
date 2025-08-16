# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity : o(n)
#Space Complexity : o(h)

#dfs approach
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        if root == None:
            return []
        self.result = []
        self.helper(root, 0)
        return self.result

    def helper(self, root: Optional[TreeNode], lvl: int) -> None:

        if root == None:
            return

        if lvl == len(self.result):
            temp = []
            temp.append(root.val)
            self.result.append(temp)
        else:
            self.result[lvl].append(root.val)

        self.helper(root.left, lvl + 1)
        self.helper(root.right, lvl + 1)


##bfs approach with queue

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity : o(n)
#Space Complexity : o(n)
from queue import Queue
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
           return []
        result = []
        q = Queue()
        q.put(root)
        while not q.empty():
            size = q.qsize()
            temp = []
            for i in range(size):
                curr = q.get()
                temp.append(curr.val)
                if curr.left!= None:
                   q.put(curr.left)
                if curr.right!= None:
                   q.put(curr.right)
            result.append(temp)
        return result