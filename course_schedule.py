"""
APPROACH:
1. Build a graph where each course points to the courses that depend on it (its "children").
2. Track the indegree (number of prerequisites) for every course.
3. Start with all courses that have zero prerequisites, since those can be taken right away.
4. Process courses one by one, and each time a course is "taken", reduce the indegree of its dependents.
5. If a dependent's indegree hits zero, it becomes takeable, so add it to the queue.

PATTERN:
Topological Sort (Kahn's Algorithm using BFS)

TIME COMPLEXITY:
O(V + E) - V is numCourses, E is number of prerequisite pairs, each visited once

SPACE COMPLEXITY:
O(V + E) - graph stores all edges, plus indegree array and queue of size V

EXAMPLE:
Input:
numCourses = 4
prerequisites = [[1,0],[2,0],[3,1],[3,2]]

Output: True
Why: order 0 -> 1 -> 2 -> 3 (or 0 -> 2 -> 1 -> 3) satisfies all prerequisites, no cycle exists
"""

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = {}  # maps each course to list of courses that depend on it

        for i in range(numCourses):
            graph[i] = []  # initialize empty dependents list for every course
        
        indegree = [0] * numCourses  # tracks number of prerequisites per course

        for course, prereq in prerequisites:
            graph[prereq].append(course)  # prereq must be taken before course

        for course, prereq in prerequisites:
            indegree[course] = indegree[course] + 1  # count each prerequisite requirement

        queue = collections.deque()  # queue used for BFS (Kahn's algorithm)
        
        # start with all courses that have no prerequisites
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)

        while queue:
            current_course = queue.popleft()  # take this course now

            # unlock dependent courses by reducing their prerequisite count
            for neighbor in graph[current_course]:
                indegree[neighbor] = indegree[neighbor] - 1

                # if a course has no more prerequisites left, it can now be taken
                if indegree[neighbor] == 0:
                    queue.append(neighbor)
        
        # if any course still has prerequisites left, there was a cycle
        for i in range(numCourses):
            if indegree[i] != 0:
                return False
        
        return True  # all courses could be taken, no cycle found