# S30 FAANG Problem # 56 {Easy}
# 102. Binary Tree Level Order Traversal


# Time Complexity: O(n) = because we traverse all the elements in the tree
# Space Complexity: O(n/2) = O(n) because, at any given level, max nodes are leaf nodes!
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach 1: add the parents at any level to the queue and then pop the elements and push their children to the Queue


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        # create a queue to add the elements/ parents and pop them when needed -> append and pop(0)  
        if root is None:
            return []
        q = []        
        result = []
        q.append(root)
        
        while(q):
            
            size = len(q) # iterate over these many elements at the level
            li = []
            for i in range(0,size):
                
                curr = q.pop(0)
                li.append(curr.val)
                if curr.left is not None:
                    q.append(curr.left) 
                if curr.right is not None:    
                    q.append(curr.right)
            
            result.append(li)
        return result

# Approach 2: DFS solution to the problem. Keep adding the nodes to the resultant lists of lists, then traverse in an inorder
# fashion.

class Solution:
    def __init__(self):
        self.result = []
        
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        self.dfs(root, 0)
        return self.result
        
    
    def dfs(self, root, level):
        
        # base case
        
        if root is None:
            return
        
        # logic case
        
        if level == len(self.result):
            self.result.append([root.val])
        else:
            self.result[level].append(root.val)
        
        self.dfs(root.left, level+1)
        # cannot add the if check here because 0the level is not present.
        self.dfs(root.right, level+1)
