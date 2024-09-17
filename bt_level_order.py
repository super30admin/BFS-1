# O(N) TIME AND O(N) SPACE

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        level_order = []
        queue = []
        queue.append(root)
        while len(queue):
            current_level = []
            for i in range(len(queue)):
                node = queue.pop(0)
                if node is None:
                    continue
                current_level.append(node.val)
                queue.append(node.left)
                queue.append(node.right)
            if len(current_level):
                level_order.append(current_level)
        return level_order
                