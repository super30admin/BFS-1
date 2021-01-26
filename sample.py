# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    Description: Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level)
    
    Time Complexicity: O(n), n -> number of items in tree
    Space Complexicity: O(2^h) or O(n), where h -> height of the tree
    
    Approach:
    1. Use BSF -> create an empty queue
    2. add values at each level under while loop by popping the queue and traversing through both left and right nodes
    
    """
    # Using BSF
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        from collections import deque
        
        result = []
        if root == None: return result
        
        queue = deque()
        queue.append(root)
        
        while len(queue) != 0:
            temp = [];
            for i in range(len(queue)):
                currNode = queue.popleft()
                temp.append(currNode.val)
                if currNode.left: queue.append(currNode.left)
                if currNode.right: queue.append(currNode.right)
            result.append(temp)
            
        return result
		
class Solution:
    
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        """
        Description: Given the total number of courses and a list of prerequisite pairs
        
        Time Complexicity: O(n)
        Space Complexicity: O(n)
        
        Approach:
        1. Create a lead degree array and adjucancy hashmap
        2. add items to queue (to check dependency)
        """       
	
        from collections import deque
        
        if len(prerequisites) == 0: return True
        ndegrees = [0]*numCourses; count = 0
        course_dict = {i: [] for i in range(numCourses)}; 
        
        for edge in prerequisites:
            course_dict[edge[1]].append(edge[0])
            ndegrees[edge[0]] += 1
        
        queue = deque()
        for i, course in enumerate(ndegrees):
            if course == 0: queue.append(i)

        while queue:
            curr = queue.popleft(); count += 1
            for k in course_dict[curr]:
                ndegrees[k] -= 1
                if ndegrees[k] == 0: queue.append(k)

        return count == numCourses

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    Description: Given a binary tree, return values from top to bottom looking from right side of it
    
    Time Complexicity: O(n) {using either BFS or DFS}
    Space Complexicity: O(n) or O(h) {BFS and DFS respectively}
    
    Approach:
    Using BFS:
    Use level order traversal of the binary tree and return right most node
    append the node to a resulting list
    
    Using DFS:
    
    """
    
    # Solution Using BFS
    def rightSideView(self, root: TreeNode) -> List[int]:
    
        from collections import deque
        
        result = []
        if root == None: return result
        
        queue = deque()
        queue.append(root)
        
        while len(queue) != 0:
            temp = [];
            for i in range(len(queue)):
                currNode = queue.popleft()
                temp.append(currNode.val)
                if currNode.left: queue.append(currNode.left)
                if currNode.right: queue.append(currNode.right)
            result.append(temp[-1])
            
        return result
    
    # Solution Using DFS
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        self.result = []
        self.dfs(root, 0)
        
        return self.result
    
    def dfs(self, root, depth):

        # Base case
        if root == None: return
        # Logic
        if depth == len(self.result):
            self.result.append(root.val)
        else:
            self.result[depth] = root.val
        
        self.dfs(root.left, depth + 1)
        self.dfs(root.right, depth + 1)
