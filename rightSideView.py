# Definition for a binary tree node.
# BFS approach
# Leetcode(199) - Successful
# Time Com : O(n), Space com: O(n)

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def rightSideView(self, root):

        if root == None:
            return None
        result = []
        queue = []
        queue.append(root)
        while len(queue) != 0:
            size = len(queue)
            for i in range(size):
                #val of node updated while traversing from left to right at each level
                temp = queue.pop(0)
                if temp.left != None:
                    queue.append(temp.left)
                if temp.right != None:
                    queue.append(temp.right)
            # the val of last node is added to result
            result.append(temp.val)
        return result

obj = Solution()
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.right = TreeNode(5)
root.right.right = TreeNode(4)
print(obj.rightSideView(root))
