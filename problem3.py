'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation : Use BFS to travel order, keep a queue where we check if left or right child is not null, if yes
remove current node and add left and all elements in queue will be bfs order. If the length of count == len -1 then
add the last element in the result.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root == None:
            return None

        totalCount = 0
        queue = [root]
        l = []
        while len(queue) != 0:
            length = len(queue)

            for i in range(0, length):
                current = queue[0]

                queue = queue[1:]

                if i == length - 1:
                    l.append(current.val)

                if current.left != None:
                    queue.append(current.left)

                if current.right != None:
                    queue.append(current.right)

        return l