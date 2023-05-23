#TC: O(n)
#SC: O(n)

from collections import deque

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def levelOrder(self, root):
        
        finalList = []

        if (root == None):
            return finalList

        queue = deque([root])

        while (len(queue) > 0):

            size = len(queue)                     
            currentList = []

            for i in range(size):
                node = queue.popleft()
                currentList.append(node.val)        

                if (node.left != None):
                    queue.append(node.left)
                if (node.right != None):
                    queue.append(node.right)

            finalList.append(currentList)           

        return finalList


class LevelOrder_Recursion(object):

    def __init__(self):
        self.finalList = []

    def __levelOrderHelper(self, root, level):

        if (root == None):
            return

        if (level == len(self.finalList)):
            self.finalList.append([])

        self.finalList[level].append(root.val)

        self.__levelOrderHelper(root.left, level + 1)
        self.__levelOrderHelper(root.right, level + 1)

    def levelOrder(self, root):

        self.__levelOrderHelper(root, 0)

        return self.finalList


class LevelOrder_Stack(object):
    def levelOrder(self, root):
        
        if (root == None):
            return []

        stack = deque([[root, 0, 0]])
        finalList = []

        while (len(stack) > 0):
            currentNode = stack[-1][0]      
            currentLevel = stack[-1][1]     
            currentCount = stack[-1][2]     

            if (currentCount == 0):

                stack[-1][2] += 1

                if (currentLevel == len(finalList)):               
                    finalList.append([])
                finalList[currentLevel].append(currentNode.val)     
                if (currentNode.left != None):
                    stack.append([currentNode.left, currentLevel + 1, 0])  

            elif (currentCount == 1):

                stack[-1][2] += 1

                if (currentNode.right != None):
                    stack.append([currentNode.right, currentLevel + 1, 0])  

            elif (currentCount == 2):
                stack.pop()

        return finalList