# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#https://leetcode.com/problems/binary-tree-level-order-traversal/
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root==None:
            return []
        final=[]
        
        queue=[root]
        while(queue!=[]):
            size=len(queue)
            interme=[]
            while(size>0):
                size-=1
                cur=queue.pop(0)
                interme.append(cur.val)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            if len(interme)>0:
                final.append(interme)
        return final
        #Time O(n)
        #Space O(n)
