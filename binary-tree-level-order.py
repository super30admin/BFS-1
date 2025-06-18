'''
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
'''

# // Time Complexity : O(n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # null edge case
        if not root:
            return []

        # we need a result array and a queue
        res = []
        q = deque()

        # init the first value
        q.append(root)
        while q:
            # critical for knowing which level we are in
            q_len = len(q)
            temp_res = []
            for i in range(q_len):
                curr_node = q.popleft()
                if curr_node.left: q.append(curr_node.left)
                if curr_node.right: q.append( curr_node.right)
                temp_res.append(curr_node.val)
            res.append(temp_res)
        
        return res
