# Time : O(n)
# Space: O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        res = []
        dq = collections.deque()
        levelele = []
        levelele_val = []
        dq.append([root, 0])
        prv_lvl = 0

        while dq:
            curr, lvl = dq.popleft()
            # print(curr.val, lvl)
            if prv_lvl != lvl:
                res.append(levelele_val)
                levelele = []
                levelele_val = []
                prv_lvl = lvl
            levelele.append(curr)
            levelele_val.append(curr.val)

            if curr.left:
                dq.append([curr.left, lvl+1])
            if curr.right:
                dq.append([curr.right, lvl+1])
        res.append(levelele_val)
        return res


