# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        """TC- ON, SC- Olenque- O(n) in case of complete binary tree O(n/2)"""
        if root is None or not root:
            return []
        q = deque()
        q.append(root)
        result = []
        while q:
            size = len(q)
            maximum = float('-inf')
            for i in range(size):
                curr = q.popleft()
                if curr.val > maximum:
                    maximum = curr.val
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            result.append(maximum)
        return result


