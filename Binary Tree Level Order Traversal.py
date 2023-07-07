# Time complexity : O(n), number of nodes
# Space complexity : O(n), number of nodes
# The code ran on Leetcode

# Maintain a queue to traverse one level at a time. Keep appending all the children to get to next level

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue = deque()
        queue.append(root)

        out = []
        if not root:
            return out

        while queue:
            temp = []
            size = len(queue)
            for _ in range(size):
                
                cur = queue.popleft()
                temp.append(cur.val)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            out.append(temp)
        
        return out


