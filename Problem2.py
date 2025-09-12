"""
TC: O(V + E) {we traverse all the courses and their prerequisite relations once}
SC: O(V + E) {we use an adjacency list for dependencies, an indegree array, and a queue}

Approach:

We apply Kahn's Algorithm (BFS Topological Sort).
Build an adjacency list where each course maps to the courses that depend on it.
Maintain an indegree array to store the number of prerequisites for each course.
Initialize a queue with all courses having zero indegree (no prerequisites).
Process the queue by removing one course at a time and reducing the indegree
of its dependent courses. If any dependent course's indegree becomes zero,
add it to the queue.
Keep a count of the courses that are processed.
If the count equals the total number of courses, return True (all courses can be finished).
Otherwise, return False (a cycle exists in the graph).

The problem ran successfully on LeetCode.
"""
from typing import List
from collections import defaultdict, deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = defaultdict(list)
        inDegrees = [0] * numCourses

        for dependent, independent in prerequisites:
            #populating the inDeg array
            inDegrees[dependent] += 1

            #forming an adj list
            adj[independent].append(dependent)
        
        q = deque()
        count = 0

        for i in range(numCourses):
            if inDegrees[i] == 0:
                q.append(i)
                count += 1

        while q:
            curr = q.popleft()

            dependencies = adj[curr]

            for each in dependencies:
                inDegrees[each] -= 1

                if inDegrees[each] == 0:
                    q.append(each)
                    count += 1
            
        return count == numCourses
        