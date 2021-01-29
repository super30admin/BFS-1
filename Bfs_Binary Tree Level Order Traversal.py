#time: O(n)
#space:  O(m) where m is the no.of leaf nodes

#Bfs
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result=[]
        if(root==None):
            return []
        q=deque()
        q.append(root)
        while(q!=deque()):
            level=[]
            size=len(q)
            for i in range(size):
                r=q.popleft()
                level.append(r.val)
                
                if(r.left!=None):
                    q.append(r.left)
                    
                if(r.right!=None):
                    q.append(r.right)
                    
            result.append(level)
            
        return result