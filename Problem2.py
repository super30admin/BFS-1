# Problem 2
# Course Schedule (https://leetcode.com/problems/course-schedule/)
import collections
from collections import defaultdict
from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        """
        Determines if all courses can be finished using Kahn's Algorithm (Topological Sort).
        
        Time Complexity: O(V + E) where V is numCourses and E is the number of prerequisites.
        Space Complexity: O(V + E) to store the adjacency list, indegrees array, and queue.
        """
        
        # SPACE: O(V) - Tracks how many prerequisites are required for each course.
        indegrees = [0 for _ in range(numCourses)]
        
        # SPACE: O(V + E) - Adjacency list mapping a course to the courses that depend on it.
        d = defaultdict(list)

        # TIME: O(E) - Build the graph and populate the indegrees array.
        for [dep, req] in prerequisites:
            indegrees[dep] += 1
            d[req].append(dep)

        # SPACE: O(V) - Queue to process courses that have zero unmet prerequisites.
        q = collections.deque()

        # TIME: O(V) - Find all courses with no prerequisites and add them to the queue.
        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)

        # Early exit: If all courses have 0 prerequisites, we can finish them all immediately.
        if len(q) == numCourses:
            return True

        # Early exit: If no courses have 0 prerequisites, there's a circular dependency involving all courses.
        if not len(q):
            return False

        # Track how many courses we successfully "take" (process).
        processedCourses = 0
        
        # TIME: O(V + E) - BFS traversal
        while len(q):
            # "Take" the course with 0 prerequisites
            course = q.popleft()
            processedCourses += 1
            
            dependents = d[course]
            
            # Reduce the indegree for all courses that depended on the one we just took
            for i in range(len(dependents)):
                dependent = dependents[i]
                indegrees[dependent] -= 1
                
                # If a dependent course now has no remaining prerequisites, queue it up
                if indegrees[dependent] == 0:
                    q.append(dependent)

        # If the number of courses we processed equals the total number of courses, 
        # it means there were no cycles and we could finish everything.
        if processedCourses == numCourses:
            return True
            
        return False