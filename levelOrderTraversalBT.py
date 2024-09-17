# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Recursive approach, before class
class Solution:
    
    def __init__(self):
        #maintain a global list of levels
        self.levels = []
    
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root:
            return self.levels
        
        #make recursive call
        self.recur(root, 0)
        
        return self.levels
        
        
    def recur(self, root:TreeNode, level):
        
        #keep appending to the levels list as you encounter another node in the level
        if len(self.levels) == level:
            self.levels.append([])
            
        self.levels[level].append(root.val)
        
        if root.left:
            self.recur(root.left, level+1)
        if root.right:
            self.recur(root.right, level+1)

#----------------------------------------------------------------                  
# // Time Complexity : O(V+E)
# // Space Complexity : O(diameter of the tree)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Iterative approach, discussed in class
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        output = []
        
        if not root:
            return output

        # initialise queue with the root     
        queue = [root]
    
        # while queue is not empty maintain size of queue at all levels and keep adding all nodes in the queue level wise
        # if popped node's left or right exist: add them to the queue in that order
        
        while queue:
            size = len(queue)
            temp = []
            for x in range(size):
                front = queue.pop(0)
                temp.append(front.val)
                if front.left is not None:
                    queue.append(front.left)
                if front.right is not None:
                    queue.append(front.right)
                    
            output.append(temp)
        
        return output
    
        
        