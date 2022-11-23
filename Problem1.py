#Time Complexity :- O(n)
#Space Complexity :- O(n)
#Approach :- Solved using BFS approach by using the queues


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue = []
        finalArray = []
        if root is None:
            return finalArray
        queue.append(root)
        while len(queue) > 0:
            size = len(queue)
            tempList = []
            for i in range(size):
                curr = queue.pop(0)
                tempList.append(curr.val)
                if curr.left is not None:
                    queue.append(curr.left)
                if curr.right is not None:
                    queue.append(curr.right)
            finalArray.append(tempList)
        return finalArray

#Time Complexity :- O(n)
#Space Complexity :- O(h)
#Approach :- Solved using DFS approach by using the queues here space is O(h) as it is using recursive stack space of height of tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    finalArray = []
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.finalArray = []
        if root is None: 
            return self.finalArray
        self.dfs(root, 0)
        return self.finalArray

    def dfs(self, root , level):
        # base case 
        if root is None:
            return

        # logic 
        if len(self.finalArray) == level:
            self.finalArray.append([])
        self.finalArray[level].append(root.val)

        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)


        

        