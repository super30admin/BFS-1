# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# add level by level
# TC and SC = O(n) o(n)

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None: return []
        q = [root]
        level, result = 0, []
        while q:
            n = len(q)
            l = []
            for i in range(n):
                curr = q.pop(0)
                l.append(curr.val)
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
            
            level += 1
            result.append(l)
        print(level)
        return result
        