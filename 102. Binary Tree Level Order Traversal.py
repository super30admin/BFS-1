#Time Complexity:O(n)
#Space Complexity:O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root==None:
            return None
        dq=collections.deque()
        dq.append(root)
        res=[]
        while(dq):
            ans=[]
            size=len(dq)
            for i in range(size):
                node=dq.popleft()
                ans.append(node.val)
                if node.left:
                    dq.append(node.left)
                if node.right:
                    dq.append(node.right)
            res.append(ans)
        return res