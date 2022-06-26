"""
Leetcode- https://leetcode.com/problems/binary-tree-level-order-traversal/ (submitted)
TC- O(N), SC- O(N) BFS
Lecture- https://youtu.be/UWwsFlt_xuo
FAQ-
What can be other ways to do it? Using dfs and passing height.


Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level
by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
"""

from collections import deque


class Solution:
    """
    Ideation-BFS using queue O(N) TC O(N) SC
    The idea here is to do BFS using queue, popping element and putting its child in FIFO, while also maintaining current
    height. The way we can achieve it is by keeping track of how many children we are adding to the queue, and iterate them
    by once
    """

    def levelOrder1(self, root):
        result = []
        if root is None:
            return result
        queue = deque(root)
        size = 1
        # iterate until all elements are visited
        while len(queue) > 0:
            count = 0
            row = []
            # for loop to iterate all children in each row at once.
            for i in range(size):
                curr = queue.popleft()
                row.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                    count += 1
                if curr.right:
                    queue.append(curr.right)
                    count += 1

            size = count
            result.append(row)

        return result

    """
    Ideation-DFS O(N) TC O(1) SC
    DFS follows depth, so if the depth hasn't been reached before create new row in the list and append to it, if the
    level already exists, append with its other cousins
    """
    def levelOrder(self, root):
        self.result = []
        if root is None:
            return self.result

        self.dfs(root, 0)
        return self.result

    def dfs(self, root, level):
        # base
        if root is None:
            return
        # if there is no result[level] initialize it
        if len(self.result) == level:
            self.result.append([root.val])
        else:
            self.result[level].append(root.val)

        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)
