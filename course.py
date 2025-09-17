# Time Complexity : O(N + P) where N is the number of courses and P is the number of prerequisites
# Space Complexity : O(N + P) where N is the number of courses and P is the number of prerequisites
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am creating a graph representation of the courses and their prerequisites using an adjacency list.
# I also maintain an indegree array to keep track of the number of prerequisites for each course.
# I then use a queue to perform a breadth-first search (BFS) starting from courses with no prerequisites (indegree 0).
# As I process each course, I decrement the indegree of its dependent courses.
# If any dependent course's indegree becomes 0, I add it to the queue.
# Finally, I check if the number of courses taken is equal to the total number of courses.
# If they are equal, it means all courses can be completed, and I return True; otherwise, I return False.

from collections import deque
from typing import List
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses
        for a,b in prerequisites:
            graph[b].append(a)
            indegree[a] += 1
        print(graph)
        q = deque()
        for courses in range(numCourses):
            if indegree[courses] == 0:
                q.append(courses)
        taken = 0
        while q:
            u = q.popleft()
            taken += 1
            for v in graph[u]:
                indegree[v] -= 1
                if indegree[v] == 0:
                    q.append(v)
                
        return taken == numCourses
