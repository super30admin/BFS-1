# Time Complexity : O(V + E)
# Space Complexity : O(V + E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Build a graph using adjacency list and track indegree of each course.
# Use BFS to process courses with indegree 0 and check if all courses can be completed 



class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = [[] for _ in range(numCourses)]   
        indegree = [0] * numCourses               

        for course, prereq in prerequisites:
            graph[prereq].append(course)
            indegree[course] += 1

        q = deque([c for c in range(numCourses) if indegree[c] == 0])
        taken = 0

        while q:
            cur = q.popleft()
            taken += 1

            for nxt in graph[cur]:
                indegree[nxt] -= 1
                if indegree[nxt] == 0:
                    q.append(nxt)

        return taken == numCourses