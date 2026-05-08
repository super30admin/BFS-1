# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        # Self-note: Do not declare a list, pop(0) in python is O(N)
        q = deque()
        results = []
        
        if root is None:
            return []

        q.append(root)

        while q:

            level = []
            size = len(q)
            for i in range(0, size):

                # do not use pop(0) with a list, O(n) time in python!
                curr = q.popleft()
                level.append(curr.val)
                
                if curr.left:
                    q.append(curr.left)

                if curr.right:
                    q.append(curr.right)

            results.append(level)


        return results    

# Time complexity: O(n), we visist all the nodes once.
# Space complexity: O(n/4) = O(n), the leaf nodes (for a balance binary tree)