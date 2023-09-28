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
        # Time Complexity: O(n)
        # Space Complexity: O(n)

        # if not root: 
        #     return []
        # q = collections.deque()
        # res=[]
        # q.append(root)
        # while q:
        #     size = len(q)
        #     temp = []
        #     for i in range (size):
        #         curr = q.popleft()
        #         temp.append(curr.val)
        #         if curr.left:
        #             q.append(curr.left)
        #         if curr.right:
        #             q.append(curr.right)
        #     res.append(temp)
        # return res

###########################################################################

        # Time Complexity: O(n)
        # Space Complexity: O(h)
        if not root:
            return[]
        res=[]
        def helper(root, level):
            if len(res) == level:
                res.append([])
            res[level].append(root.val)
            if root.left:
                helper(root.left, level+1)
            if root.right:
                helper(root.right, level+1)
        helper(root,0)
        return res
