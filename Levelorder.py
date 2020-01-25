#Time Complexity- o(n)
# Space Complexity- o(n)
# Run on leetcode-Yes
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res=[]
        if root == None:
            return res
        q=[]
        q.append(root)
        while q:
            temp=[]
            size=len(q)
            for i in range(size):
                node=q.pop(0)
                temp.append(node.val)
                if node.left!=None:
                    q.append(node.left)
                if node.right!=None:
                    q.append(node.right)
            res.append(temp)
        return res

   
