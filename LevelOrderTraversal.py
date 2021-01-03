'''
Solution
1.  Using a Queue (BFS), for each level, maintain a size so that one new ArrayList is created and the size number of
    elements are added to that List (or Level).
2.  Using Recursion, add the level as an extra parameter to each recursive call and add the node of corresponding level
    to the corresponding List.
3.  Using Stack (DFS), the approach is the same as in how one visualizes the recursive stack of recursion and do the same
    using iteration.

Time Complexity: O(n) in all three approaches
Space Complexity: O(n) in BFS and O(h) in DFS and Recursion

--- Passed all testcases on Leetcode successfully
'''

from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class LevelOrder_Queue(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        finalList = []

        #   edge case check
        if (root == None):
            return finalList

        #   initialize the queue
        queue = deque([root])

        #   Iterate until the queue is empty
        while (len(queue) > 0):

            size = len(queue)                       #   maintain the size of the Queue to put only those many elements at each level
            currentList = []

            for i in range(size):
                node = queue.popleft()
                currentList.append(node.val)        #   push node's left and right nodes if they exist

                if (node.left != None):
                    queue.append(node.left)
                if (node.right != None):
                    queue.append(node.right)

            finalList.append(currentList)           #   List corresponding to each level

        return finalList


class LevelOrder_Recursion(object):

    def __init__(self):
        self.finalList = []

    def __levelOrderHelper(self, root, level):

        #   base case
        if (root == None):
            return

        #   whenever a new level has been entered
        if (level == len(self.finalList)):
            self.finalList.append([])

        #   push element to the List at that level
        self.finalList[level].append(root.val)

        #   recursive calls on left and right nodes along with level parameter
        self.__levelOrderHelper(root.left, level + 1)
        self.__levelOrderHelper(root.right, level + 1)

    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        self.__levelOrderHelper(root, 0)

        return self.finalList


class LevelOrder_Stack(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        #   base case
        if (root == None):
            return []

        #   maintain a stack with each element containing 3 elements (node, level and how many children have been traversed)
        stack = deque([[root, 0, 0]])
        finalList = []

        while (len(stack) > 0):
            currentNode = stack[-1][0]      #   node
            currentLevel = stack[-1][1]     #   level
            currentCount = stack[-1][2]     #   count of children traversed (out of atmost of 2 children)

            if (currentCount == 0):

                stack[-1][2] += 1

                if (currentLevel == len(finalList)):                #   creating a new List
                    finalList.append([])
                finalList[currentLevel].append(currentNode.val)     #   append to that List

                if (currentNode.left != None):
                    stack.append([currentNode.left, currentLevel + 1, 0])   #   add left node if exists


            elif (currentCount == 1):

                stack[-1][2] += 1

                if (currentNode.right != None):
                    stack.append([currentNode.right, currentLevel + 1, 0])    #   add left node if exists

            elif (currentCount == 2):
                stack.pop()

        return finalList
