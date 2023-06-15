# BFS-1
# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution: 

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        queue = []

        result = []
    
    # If the root is not null, add it to the queue
        if root:
            queue.append(root)

        # While the queue is not empty, repeat steps 4-7
        while queue:
            # Get the size of the queue and initialize an empty list to store the nodes of the current level
            size = len(queue)
            level = []
            
            # Loop through the elements of the current level and add them to the list
            for i in range(size):
                node = queue.pop(0)
                level.append(node.val)
                
                # For each element of the current level, add its children to the queue
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            # Add the current level list to the result list
            result.append(level)

        # Return the result list
        return result

# Problem 2
Time complexity:

O(N+E) where N is the number of courses and E is the number of prerequisites.

Space complexity:

O(N+E) for the adjacency list and the indegree array.

Course Schedule (https://leetcode.com/problems/course-schedule/)

class Solution:

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        graph = defaultdict(list)

        for course, prereq in prerequisites:

            graph[prereq].append(course)
        
        # Step 2: Create an array "indegrees" to store the number of incoming edges for each node in the graph

        indegrees = [0] * numCourses

        for prereq, _ in prerequisites:
            indegrees[prereq] += 1
        
        # Step 3: Add all the nodes with indegree 0 to a queue
        queue = deque()
        for course in range(numCourses):
            if indegrees[course] == 0:
                queue.append(course)
        
        # Step 4: Topological Sort
        while queue:
            course = queue.popleft()
            for prereq in graph[course]:
                indegrees[prereq] -= 1
                if indegrees[prereq] == 0:
                    queue.append(prereq)
        
        # Step 5: Check if we have removed all the courses successfully
        return all(indegree == 0 for indegree in indegrees)


