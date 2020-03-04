'''
Solution
1.  Using a Queue (BFS), for each level, maintain a size so that the last element traversed in that level is being added.
    If for a particular node, if left node is processed, the last element is the righmost and else the first element is
    the righmost.
2.  Using Recursion, add the level as an extra parameter to each recursive call and add the last node of corresponding
    level. So, this again depends on whether you processed left node first or the right one.
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

class RightSideView_Queue_Left(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #   base case
        if (root == None):
            return []

        finalList = []
        queue = deque([root])               #   initialize the queue

        #   Iterate until the queue is empty
        while (len(queue) > 0):

            size = len(queue)
            node = None

            #   maintain the size of the Queue to put only that rightmost element at each level
            for i in range(size):

                node = queue.popleft()

                #   push node's left and right nodes if they exist
                if (node.left != None):
                    queue.append(node.left)
                if (node.right != None):
                    queue.append(node.right)

            finalList.append(node.val)

        return finalList


class RightSideView_Queue_Right(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #   base case
        if (root == None):
            return []

        finalList = []
        queue = deque([root])                   #   initialize the queue

        #   Iterate until the queue is empty
        while (len(queue) > 0):

            size = len(queue)
            node = queue.popleft()
            finalList.append(node.val)

            #   maintain the size of the Queue to put only that rightmost element at each level
            for i in range(size - 1):

                #   push node's left and right nodes if they exist
                if (node.right != None):
                    queue.append(node.right)

                if (node.left != None):
                    queue.append(node.left)

                node = queue.popleft()

            if (node.right != None):
                queue.append(node.right)

            if (node.left != None):
                queue.append(node.left)

        return finalList


class RightSideView_Recursion_Left(object):

    def __init__(self):
        self.finalList = []

    def __rightSideViewHelper(self, root, level):
        #   base case
        if (root == None):
            return

        #   whenever a new level has been entered
        if (level == len(self.finalList)):
            self.finalList.append(root.val)
        elif (level < self.finalList):
            self.finalList[level] = root.val

        #   recursive calls on left and right nodes along with level parameter
        self.__rightSideViewHelper(root.left, level + 1)
        self.__rightSideViewHelper(root.right, level + 1)

    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.__rightSideViewHelper(root, 0)
        return self.finalList


class RightSideView_Recursion_Right(object):

    def __init__(self):
        self.finalList = []

    def __rightSideViewHelper(self, root, level):
        #   base case
        if (root == None):
            return

        #   whenever a new level has been entered
        if (level == len(self.finalList)):
            self.finalList.append(root.val)

        #   recursive calls on left and right nodes along with level parameter
        self.__rightSideViewHelper(root.right, level + 1)
        self.__rightSideViewHelper(root.left, level + 1)

    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.__rightSideViewHelper(root, 0)
        return self.finalList


class RightSideView_Stack_Left(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #   base case
        if (root == None):
            return []

        finalList = []

        #   maintain a stack with each element containing 3 elements (node, level and how many children have been traversed)
        stack = deque([[root, 0, 0]])

        while (len(stack) > 0):

            currentNode = stack[-1][0]      #   node
            currentLevel = stack[-1][1]     #   level
            currentCount = stack[-1][2]     #   count of children traversed (out of atmost of 2 children)

            if (currentCount == 0):

                stack[-1][2] += 1

                if (currentLevel == len(finalList)):        #   add a new value to the List
                    finalList.append(currentNode.val)
                else:
                    finalList[currentLevel] = currentNode.val   #   update the existing value with righmost node

                if (currentNode.left != None):
                    stack.append([currentNode.left, currentLevel + 1, 0])   #   if left exists

            elif (currentCount == 1):

                stack[-1][2] += 1

                if (currentNode.right != None):
                    stack.append([currentNode.right, currentLevel + 1, 0])  #   if right exists

            elif (currentCount == 2):

                stack.pop()

        return finalList


class RightSideView_Stack_Right(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #   base case
        if (root == None):
            return []

        finalList = []

        #   maintain a stack with each element containing 3 elements (node, level and how many children have been traversed)
        stack = deque([[root, 0, 0]])

        while (len(stack) > 0):

            currentNode = stack[-1][0]           #   node
            currentLevel = stack[-1][1]          #   level
            currentCount = stack[-1][2]          #   count of children traversed (out of atmost of 2 children)

            if (currentCount == 0):

                stack[-1][2] += 1

                if (currentLevel == len(finalList)):                #   creating a new List and update it only once
                    finalList.append(currentNode.val)

                if (currentNode.right != None):
                    stack.append([currentNode.right, currentLevel + 1, 0])      #   if right exists

            elif (currentCount == 1):

                stack[-1][2] += 1

                if (currentNode.left != None):
                    stack.append([currentNode.left, currentLevel + 1, 0])   #   if left exists

            elif (currentCount == 2):

                stack.pop()

        return finalList
