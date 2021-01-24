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
        course_dict = {}; ndegrees = [0]*numCourses; count = 0
        for edge in prerequisites:
            if not edge[1] in course_dict.keys():
                course_dict[edge[1]] = [edge[0]]
            else:
                course_dict[edge[1]].append(edge[0])
            ndegrees[edge[0]] += 1
                
        queue = deque()
        for i in range(len(ndegrees)):
            if ndegrees[i] == 0: queue.append(ndegrees[i])
                
        while len(queue) != 0:
            curr = queue.popleft(); count += 1
            for k in course_dict[curr]:
                ndegrees[k] -= 1
                if ndegrees[k] == 0: queue.append(ndegrees[k])
                    
        if count == numCourses: return True
        return False
                    
        
