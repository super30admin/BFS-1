'''
Time Complexity: O(n)
Space Complexity: O(n) Height of tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):

        # BFS
        if root == None:
            return []
        res = [[root.val]]
        queue = collections.deque([root])
        temp_queue = collections.deque([])
        temp_res = []
        while queue:
            u = queue.popleft()
            if u.left != None:
                temp_queue.append(u.left)
                temp_res.append(u.left.val)
            if u.right != None:
                temp_queue.append(u.right)
                temp_res.append(u.right.val)
            if not queue:
                queue = temp_queue
                temp_queue = collections.deque([])
                if temp_res:
                    res.append(temp_res)
                    temp_res = []
        return res