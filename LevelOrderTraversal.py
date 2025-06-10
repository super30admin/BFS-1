# Time Complexity: O(n)
# Space Complexity: O(w) space used by queue and in worst case holds all the node at the widest level of tree.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # BFS
        result = []
        if root == None: return result
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            # list for each level
            li = []
            for _ in range(size):
                curr = q.popleft()
                li.append(curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
            result.append(li)
        return result
