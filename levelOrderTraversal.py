# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from queue import Queue


class Solution:
    """
    TC: O(total number of nodes) = O(n)
    SC: O(max number of children on a level) = O(max. breadth of the tree)
    """

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        if root == None:
            return None

        output = []
        queue = Queue()
        queue.put(root)

        while not queue.empty():
            size = queue.qsize()
            temp = []

            for i in range(size):
                front = queue.get()
                temp.append(front.val)

                if front.left != None:
                    queue.put(front.left)

                if front.right != None:
                    queue.put(front.right)

            output.append(temp)

        return output
