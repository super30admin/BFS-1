# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def levelOrder(self, root) :

        result = []
        queue = []
        if not root:
            return []
        queue.append(root)

        while len(queue) != 0:
            listn = []
            for i in range(len(queue)):

                curr = queue.pop(0)

                if not curr:
                    return

                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
                listn.append(curr.val)

            result.append(listn)

        return result


