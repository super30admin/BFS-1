# APPROACH 1: BFS
# Time Complexity : O(n), n: number of nodes in BT
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do BFS.
# 2. Each time, store the number of nodes in a level, so that I can add that many nodes in the list and then add it to the main result.
# 3.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if root is None:
            return None
        
        result = []
        queue = deque()
        queue.append(root)
        
        while len(queue) > 0:
            size = len(queue)
            temp = []
            while size > 0:
                node = queue.popleft()
                temp.append(node.val)
                
                if node.left is not None: 
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
                size -= 1
                
            result.append(temp)
            
        return result
        
        
 
# APPROACH 2: DFS - Iterative 
# Time Complexity : O(n), n: number of nodes in BT
# Space Complexity : O(h), h: height of BT
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do DFS
# 2. Each time, store node and level number in stack
# 3. if level number same as result size, then add a new list for it. else append to corresponding level's list in result

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if root is None:
            return None
        
        result, curr_node, level, stack, isFirst = [], root, -1, [], True
        
        while curr_node is not None or (len(stack) > 0 or isFirst):
            isFirst = False
            
            while curr_node is not None:
                level += 1
                if level == len(result):
                    result.append([curr_node.val])
                elif level < len(result):
                    result[level].append(curr_node.val)
                stack.append((curr_node, level))
                curr_node = curr_node.left 
                
            node = stack.pop()
            curr_node, level = node[0], node[1]
            curr_node = curr_node.right
            
        return result
                
 
# APPROACH  3: DFS - Recursive
# Time Complexity : O(n), n: number of nodes in BT
# Space Complexity : O(h), h: height of BT
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Same as above (approach 2) but in a recursive way (Preorder traversal). 
# 2. send current level in each function call
# 3. store result as global variable

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
        
        
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if root is None:
            return None
        
        result = []
        self.helper(root, 0)
        return self.result
    
    
    def helper(self, root, level):
        if root is None:
            return
        
        if level == len(self.result):
            self.result.append([root.val])
        elif level < len(self.result):
            self.result[level].append(root.val)
            
        self.helper(root.left, level + 1)
        self.helper(root.right, level + 1)
                
            
        
