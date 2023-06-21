# Time and space complexity : O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result =[]
        if root is None:
            return result
        q = Queue()
        q.put(root)
        while not q.empty():
            size = q.qsize()  # Used for determining the levels
            li = []
            for i in range(0,size):
                curr = q.get()
                li.append(curr.val)
                if(curr.left is not None):
                    q.put(curr.left)
                if(curr.right is not None):
                    q.put(curr.right)
            result.append(li)
        return result