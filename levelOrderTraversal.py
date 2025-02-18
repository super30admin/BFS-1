"""
BFS traversal -
TC - O(n)
SC - O(n/2) since at every point in the queue we have n/2 elements. We ignore the constant 1/2, so the SC is O(n)
Final SC - O(n)
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None: return []

        rtnData = []

        # deque for BFS
        q = deque()
        q.append(root)

        while q:
            # get the number of elements at that level
            qsize = len(q)
            # temp list
            qlist = []
            for i in range(qsize):
                curr = q.popleft()
                # append to temp list
                qlist.append(curr.val)
                # append child elements if present
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
            rtnData.append(qlist)

        return rtnData