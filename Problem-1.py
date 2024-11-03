#Approach
# for every level find the length of the queue befor poping , thise length is th no of elements in the level
# Run the loop for size and add the children of those in queue and pop th epresent elemnet in que is the level order


#Complexiities
#Time : O(n)
#Space : O(n)



from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        queue =[]
        if root != None:
            result.append([root.val])
            queue.append((root.left, root.right, 1))
            res = []
            present_level = 1
            while queue:
                left, right, level = queue[0]

                if (present_level != level):
                    if (res):
                        result.append(res.copy())
                        res.clear()
                        present_level = level
                queue.pop(0)
                if (left != None):
                    res.append(left.val)
                    if (left.left != None or left.right != None):
                        queue.append((left.left, left.right, level + 1))
                if (right != None):
                    res.append(right.val)
                    if (right.left != None or right.right != None):
                        queue.append((right.left, right.right, level + 1))

            if (res):
                result.append(res.copy())

        return result


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        if root is None:
            return []
        result = []
        queue = []

        queue.append(root)

        while queue:
            size = len(queue)
            level = []
            for _ in range(size):
                curr = queue.pop(0)
                level.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(level)
        return result


