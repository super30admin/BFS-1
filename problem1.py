'''
Iterative:
Time Complexity: O(V+E)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation : Use BFS to travel order, keep a queue where we check if left or right child is not null, if yes
remove current node and add left and all elements in queue will be bfs order.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return []
        queue = [root]
        l = []
        left = 0
        right = 0
        level = 0
        while len(queue) != 0:
            l.append([])

            lenght = len(queue)

            for i in range(0, len(queue)):
                current = queue[0]

                l[level].append(current.val)

                queue = queue[1:]

                if current.left != None:
                    queue.append(current.left)

                if current.right != None:
                    queue.append(current.right)
            level = level + 1

        return l

