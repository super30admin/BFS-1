# Course Schedule

from collections import deque
from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # Array to track the number of prerequisites for each course.
        in_degree = [0] * numCourses
        
        # Map each course to the set of courses that depend on it.
        dependency_map = {}
        
        # If there are no prerequisites, every course can be finished.
        if not prerequisites:
            return True
        
        # Build the in-degree array and dependency map.
        for prereq in prerequisites:
            next_course, prev_course = prereq
            if prev_course in dependency_map:
                dependency_map[prev_course].append(next_course)
            else:
                dependency_map[prev_course] = [next_course]
            in_degree[next_course] += 1
        
        # Initialize queue with courses that have no prerequisites.
        queue = deque()
        for course in range(numCourses):
            if in_degree[course] == 0:
                queue.append(course)
        
        # Counter for the number of courses that can be processed.
        completed_courses = 0
        
        # Process courses in topological order.
        while queue:
            course = queue.popleft()
            completed_courses += 1
            # Decrease the prerequisite count for dependent courses
            for dependent in dependency_map.get(course, []):
                in_degree[dependent] -= 1
                # If the dependent course now has no prerequisites, add it to the queue.
                if in_degree[dependent] == 0:
                    queue.append(dependent)
        
        # Return True if all courses can be completed.
        return completed_courses == numCourses
