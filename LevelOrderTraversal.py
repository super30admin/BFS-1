# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach: BFS using queue
# We will traverse to every node and store the list of their children in our result list. 
# We will maintain a queue. We will pop the element from the queue, traverse and store its children's list. Its a normal bfs with just a little modification.

# Time Complexity: O(n); n = no of nodes
# Space Complexity: O(1)

# class Solution:
#     def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
#         result = []
#         if root == None:
#             return result
        
#         q = []
#         q.append(root)
        
#         while len(q) != 0:
#             demo = []
#             size = len(q)
            
#             for i in range(size):
#                 temp = q.pop(0)
#                 demo.append(temp.val)
#                 if temp.left:
#                     q.append(temp.left)
#                 if temp.right:
#                     q.append(temp.right)
#             result.append(demo)
        
#         return result
    
# Approach 2: DFS using stack
# In this approach we will traverse in a depth first order. A separate list in our result list is maintained for each level and whenever a node of a certain level is reached its value is added to the to one of the lists in result depending on the level of that node. For example a node of level 0(root) will be added to the first list in the result list. Same logic goes for nodes at levels 1,2....n.

# Time Complexity: O(n); n = no of nodes
# Space Complexity: O(1)

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        # At first result list would be empty
        self.result = []    
        if root == None:
            return self.result
        
        self.dfs(root, 0)   
        return self.result
    
    def dfs(self, root, level):
        if root == None:
            return
        
        # This checks if a node at a new level is traversed that was not traversed before then add a list
        # Size of the list will always tell us the levels that has been traversed till far
        if level == len(self.result):
            self.result.append([])
            
        # Add the node in one of 'level'th list in the result list
        self.result[level].append(root.val)
        
        # Again perform dfs on left and right children
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)
        
    
