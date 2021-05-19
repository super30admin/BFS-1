# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        '''
        TC: O(n) no of nodes
        SC: O(n) for maintaining the queue
        
        maintain a q, and traverse the tree by maintaining the levels 
        '''
        ans  = []
        q = []
        q.append(root)
        while q:
            l = len(q)
            level = []
            while l:
                x = q.pop(0)
                level.append(x.val)
                l-=1
                if x.left: q.append(x.left)
                if x.right: q.append(x.right)
            ans.append(level)
        return ans
                