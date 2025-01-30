# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # TC : O(n)
        # SC : O(n)
        if root is None:
            return []
        res = []
        q = deque()
        q.append(root)
        while q:
            cursize = len(q)
            temp = []
            while cursize > 0:
                curnode = q.popleft()
                cursize -= 1
                temp.append(curnode.val)
                if curnode.left:
                    q.append(curnode.left)
                if curnode.right:
                    q.append(curnode.right)
            res.append(temp)
        return res
        # try with dfs