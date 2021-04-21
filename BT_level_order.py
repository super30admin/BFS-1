# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return None
        q=deque([root])
        res=[]
        nodes=0
        while(q):
            level=[]
            nodes=len(q)
            while(nodes):
                temp=q.popleft()
                level.append(temp.val)
                nodes-=1
                if temp.left!=None:
                    q.append(temp.left)
                if temp.right!=None:
                    q.append(temp.right)
            res.append(level)
        return res
