# Space Complexity: O(N)
# Time Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        q = collections.deque()
        q.append(root)
        ans = []
        while q: 
            s = len(q)
            li = []
            for _ in range(s):
                node = q.popleft()
                li.append(node.val)
                if node.left: 
                    q.append(node.left)
                if node.right: 
                    q.append(node.right)
            ans.append(li)

            
        return ans

