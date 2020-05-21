# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#BFS Solution:
#Time Complexity:O(n)
#Space Complexity:O(n)
#Ran successfully on Leetcode:Yes
#Difficulties: Since I am using nested for loop while returning result, does this make my TC as O(N^2)?? 
#Algorithm:
# 1. Create a list of lists, to store root.
# 2. For each level in the binary tree, create a array-record in whihc each node's right and left child are appended. 
# 3. After a particular nodes children are finshed dealt with, we append the record array to thw list of lists created.
# 4. Then the result is returned.

#BFS solutions
# Solution using lists of lists.
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root:
            return []
        q=[[root]]
        for level in q:
            record=[]
            for node in level:
                
                if node.left:
                    record.append(node.left)
                if node.right:
                    record.append(node.right)
            if record:
                q.append(record)
        return [[x.val for x in level] for level in q]
    
    
# # Solution using dqueue. Here we follow the same fashion as above, except we use dqueue to store the children.
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        q, result = deque(), []
        if root:
            q.append(root)
        while len(q):
            level = []
            for _ in range(len(q)):
                x = q.popleft()
                level.append(x.val)
                if x.left:
                    q.append(x.left)
                if x.right:
                    q.append(x.right)
            result.append(level)
        return result
        
#DFS Solutions:
# 1. Create a globally accessible variable result.
# 2. Create a helper function with level variable. 
# 3. Check if the level and the number of arrays in the result are same or not, if yes, we create a new array in the result, else we search for the array corresponding to the level , and append the value of the node to it. 
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result=[]  
        if not root:
                return []

        self.helper(root,0,result)
        return result
    def helper(self,root,level,result):
            if not root :
                return 
            if len(result)==level:
                result.append([])
            result[level].append(root.val)
            self.helper(root.left,level+1,result)
            self.helper(root.right,level+1,result)

        
        

