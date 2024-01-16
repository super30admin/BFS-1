""" Explanation: Build a directed graph where the nodes represent courses and the directed edges 
    represent prerequisites.
    Initialize an array in_degree to keep track of the in-degree of each course.
    Add prerequisites to the graph and update the in-degree array.
    Initialize a queue with courses having in-degree 0.
    Perform topological sort using BFS by dequeuing courses with in-degree 0 and updating in-degrees of their neighbors.
    If all courses have in-degree 0 after the topological sort, return True; otherwise, return False.
    
    Time Complexcity: O(V+E) where V is number of vertices of the graph and E is the num of edges
    Space Complexcity: O(V+E) for the graph and also for the in_degree array
    All TC's passed on LC: Yes
"""


from collections import defaultdict, deque

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        # Build a directed graph
        graph = defaultdict(list)
        in_degree = [0] * numCourses

        for course, prereq in prerequisites:
            graph[prereq].append(course)
            in_degree[course] += 1

        # Initialize a queue for topological sort
        queue = deque()

        # Add courses with in-degree 0 to the queue
        for i in range(numCourses):
            if in_degree[i] == 0:
                queue.append(i)

        # Perform topological sort
        while queue:
            course = queue.popleft()
            for neighbor in graph[course]:
                in_degree[neighbor] -= 1
                if in_degree[neighbor] == 0:
                    queue.append(neighbor)

        # Check if all courses have in-degree 0
        return all(in_degree[i] == 0 for i in range(numCourses))