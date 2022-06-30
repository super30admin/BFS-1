# Time Complexity: O(n)
# Space Complexity: O(n)


from collections import deque 
# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right


class Solution:

    # BFS Solution ----> by maintaining the size variable
    # for example, [3,9,20,15,7]
    # first, put root element to the queue. and calculate the size of queue. --> [3]
    # visit it's right and left element and add them to the queue and remove the root. --> [9,20]
    # make that root to list and put that list in resulting list.-->[[3]]
    # same thing will repeat for the left and right root.
    def levelOrder(self, root):
        allLevels = []
        queue = deque([root])
        if root == None:
            return
        
        while queue:
               
                level = []
                size = len(queue)
            
                for i in range(size):
                    element = queue.popleft()
                    level.append(element.val)
                    if element.left:
                         queue.append(element.left)
                    if element.right:
                         queue.append(element.right)
                allLevels.append(level)
                
        return allLevels


    # DFS Solution ---->
    # maintain the level.
    # make 1 list to for result.
    # at the 1st element, calculate  it's level.
    # if level and len(result) are same, than make nested list in result and add root elemnt to the nested list
    # same thing will repeat for childs.
    #  first it will go for left child and then right child.
    def levelOrder2(self, root):
        self.result = []
        self.dfs(root,0)
        return self.result
        
        
    def dfs(self,root,level):
            if root == None:
                return
            subList = []
            if len(self.result) == level:
                self.result.append(subList)
            
            self.result[level].append(root.val)
            self.dfs(root.left, level+1)
            self.dfs(root.right, level+1)