# O(n)
# O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if not root:
            return []
        
        q = deque()
        
        q.append(root)
        currSize = 1
        while len(q) != 0:
            r = []
            size = currSize  
            currSize = 0  
            for i in range(size):
                node = q.popleft()
                r.append(node.val)
                if node.left:
                    currSize +=1 
                    q.append(node.left)
                if node.right:
                    currSize +=1
                    q.append(node.right)
            result.append(r)
        
        return result