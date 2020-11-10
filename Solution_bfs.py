"""
Time complexity O(N)
SPace complexity Asymptotically O(N) in recursive stack
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_bfs:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        q=[]
        res=[]
        q.append(root)
        while q:
            size=len(q)
            temp=[]
            for i in range(size):
                curr=q.pop(0)
                temp.append(curr.val)
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
            res.append(temp)
        
        return res