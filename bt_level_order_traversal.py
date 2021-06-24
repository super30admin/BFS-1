# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(n)
from collections import deque


class Solution(object):
    #     Gobal result list
    result = []

    def queuebasic(self, root):
        #         initilaize it to null
        self.result = []
        #     initialize the queue
        queue = deque()
        #     Base condition

        if not root:
            return []
        #         add root to the queue
        queue.append(root)

        #         untill queue lengtn is not 0
        while len(queue) != 0:
            #         create level order list
            temp_list = []
            #             iterate over the queue and pop the first element and if left and right child present of root then add that too in the queue
            # and append it to list
            for i in range(len(queue)):

                curr = queue.popleft()

                if not curr:
                    return

                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
                temp_list.append(curr.val)

            self.result.append(temp_list)

        return self.result

    def LevelDFS(self, root, count):

        #         Base Condition
        if not root:
            return

        #         if the count is equal to length of the gobal result list
        #         then append new empty list to the final result
        if count == len(self.result):
            self.result.append([])

        #         we will call same function recursivly on left child of the tree and update the count by 1
        self.LevelDFS(root.left, count + 1)
        #         we will get the current count list in result and append current root val
        self.result[count].append(root.val)
        #         same will follow for right child of the tree
        self.LevelDFS(root.right, count + 1)

    def levelDFSMain(self, root):
        #     main function to call dfs on current trr
        self.result = []
        if not root:
            return self.result

        self.LevelDFS(root, 0)
        return self.result

    def levelOrder(self, root):

        return self.levelDFSMain(root)
        return self.queuebasic(root)

        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
