# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        q=[(root)]
        l=[]
        while q:
            w=[]
            ll=[]
            for _ in range(len(q)):
                i=q.pop(0)
                ll.append(i.val)
                if i.left:
                    w.append(i.left)
                if i.right:
                    w.append(i.right) 
            q=w
            l.append(ll)
        return(l)
            
        