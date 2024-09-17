# APPROACH 1: DFS (recursive) right, left
# Time Complexity : O(n), n: number of nodes of BT
# Space Complexity : O(h), h: height of BT
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. DFS recursively, go right of every node before going to it's left
# 2. Add node to the result if level is same as the size of the result (means for that level, node has not been added to the result)
# 3. level for each node is maintained locally and result is maintained globally.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
        
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        if root is None:
            return None
        
        self.dfs(root, 0)
        return self.result
    
    
    def dfs(self, root, level):
        if root is None:
            return
        
        if level == len(self.result):
            self.result.append(root.val)
            
        self.dfs(root.right, level + 1)
        self.dfs(root.left, level + 1)
        
        
        
        
        

# APPROACH 2: DFS, RECURSIVE LEFT RIGHT
# Time Complexity : O(n), n: number of nodes of BT
# Space Complexity : O(h), h: height of BT
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. DFS recursively, go left of every node before going to it's right
# 2. Append node to the result if level is same as the size of the result (means for that level, it's the first node encountered). If not overwrite the index corresponding to 
#    the level (in this manner we will get the rightmost node for each level)
# 3. level for each node is maintained locally and result is maintained globally.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
        
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        if root is None:
            return None
        
        self.dfs(root, 0)
        return self.result
    
    
    def dfs(self, root, level):
        if root is None:
            return
        
        if level == len(self.result):
            self.result.append(root.val)
        else:
            self.result[level] = root.val
            
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)
        
        
        
       


# APPROACH  3: BFS
# Time Complexity : O(n), n: number of nodes of BT 
# Space Complexity : O(n), (as width of the tree max is n/2 due to leaf nodes)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do a levelorder traversal of tree using BFS.
# 2. Maintain size, st we know till what node of the queue belongs to a level and process only there in each iteration
# 3. Add only the last node of this level list in each iteration.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
   
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        if root is None:
            return None
        
        queue, result = deque(), []
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
                
            result.append(temp[-1])    
            
        return result           
    
