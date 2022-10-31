from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root):
        result = []
        if not root:
            return []
        queue = deque()
        queue.append(root)
        while queue:
            res = []
            for _ in range(len(queue)):
                node = queue.popleft()
                print("HELLO", node)
                res.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.append(res)
        return result
                
if __name__ == "__main__":
    s = Solution()
    root = TreeNode()
    root = [3,9,20,None,None,15,7]
    print(s.levelOrder(root))