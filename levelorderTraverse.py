"""
TC: O(N) iterate through all nodes
SP: O(N) at nmax N/2 elements will be in the queue
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return
        q = deque([root])
        res = []
        while q:
            curr = []
            curr_len = len(q)
            for _ in range(curr_len):
                r = q.popleft()
                curr.append(r.val)
                if r.left:
                    q.append(r.left)
                if r.right:
                    q.append(r.right)
            res.append(curr)
        return res



        