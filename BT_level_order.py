# O(N) TIME AND O(D) SPACE WHERE N IS NO.OF NODES AND D IS DIAMETER OF TREE
from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        que = deque()
        output = []
        que.append(root)
        while que:
            size = len(que)
            current_level = []
            for _ in range(size):
                node = que.popleft()
                if node.left is not None:
                    que.append(node.left)
                if node.right is not None:
                    que.append(node.right)
                current_level.append(node.val)
            output.append(current_level)
        return output
                
        
        
        