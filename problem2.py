
# Time Complexity  : O(V + E)
#   → V = number of courses (nodes)
#     E = number of prerequisite pairs (edges)
#   We visit each node and edge once in the topological sort.
#
# Space Complexity : O(V + E)
#   → We use an adjacency list (graph), an indegree array,
#     and a queue storing up to all courses.
#
# Did this code successfully run on Leetcode? : Yes
#
# Any problems you faced while coding this? :
#   Remembering to increment count only when a course is dequeued 
#   or added when indegree becomes 0. Also ensuring to check for 
#   isolated nodes with no prerequisites.


from typing import List
from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # indegree[i] = number of prerequisites required for course i
        indegree = [0] * numCourses
        graph = {}  # adjacency list: {course: [dependent_courses]}
        
        # Build the graph and indegree array
        for pre in prerequisites:
            indegree[pre[0]] += 1  # increase indegree for the dependent course
            if pre[1] not in graph:
                graph[pre[1]] = []
            graph[pre[1]].append(pre[0])  # pre[1] → pre[0]

        q = deque()  # queue for BFS (courses that can be taken)
        count = 0    # number of courses that can be completed
        
        # Add all courses that have no prerequisites
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
                count += 1

        # Early checks
        if not q:  # no starting course available
            return False
        if count == numCourses:  # all courses are already independent
            return True

        # 🔁 BFS traversal (Topological Sort)
        while q:
            curr = q.popleft()  # take a course that has no remaining prereqs
            dependencies = graph.get(curr)  # get courses depending on 'curr'

            if dependencies:
                for dep in dependencies:
                    indegree[dep] -= 1  # reduce prerequisite count
                    if indegree[dep] == 0:
                        q.append(dep)  # course can now be taken
                        count += 1
                        # If all courses are processed, return True
                        if count == numCourses:
                            return True

        # If some courses couldn't be completed (cycle exists)
        return False
