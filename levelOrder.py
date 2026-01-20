# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        res = []
        queue = deque([root])
        
        while queue:
            level_size = len(queue)
            current_level = []
            
            for i in range(level_size):
                # 1. Pop the node from the LEFT of the queue here
                node = queue.popleft()
                # 2. Add the node's value to current_level
                current_level.append(node.val)
                # 3. Add Left child to queue (if it exists)
                if node.left:
                    queue.append(node.left)
                # 4. Add Right child to queue (if it exists)
                if node.right:
                    queue.append(node.right)
                
            res.append(current_level)
        return res

            