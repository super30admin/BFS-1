"""
problem_1: Course Schedule
TC: O(V+E)
SC: O(V+E)
Approach: BFS
"""

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not numCourses:
            return True

        adj_list = defaultdict(list)
        indegree = [0] * numCourses
        q = []
        count = 0

        for course, pre_req in prerequisites:
            adj_list[pre_req].append(course)
            indegree[course] + =1

        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
                count + =1

        while q:
            curr = q.pop(0)
            courses = adj_list.get(curr)
            if not courses:
                continue

            for course in courses:
                indegree[course] - =1
                if indegree[course] == 0:
                    q.append(course)
                    count + =1

        if count == numCourses:
            return True

        return False
