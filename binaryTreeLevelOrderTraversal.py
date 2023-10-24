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
        # Time Complexity: O(N)
        # Space: O(D)
        if not root: return []
        res = []
        # if not root.left and not root.right: return res
        stk = collections.deque([(root, 1)])
        while stk:
            n, level = stk.popleft()
            if len(res) < level:
                res.append([])
            res[level - 1].append(n.val)
            if n.left:
                stk.append((n.left, level + 1))
            if n.right:
                stk.append((n.right, level + 1))
        return res



