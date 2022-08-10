# TC : O(numCourses + prerequisites)
# SC : O(numCourses + prerequisites)
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        adjacentList, q, indegree, count = [[] for _ in range(numCourses)], deque(), [0] * numCourses, 0
        for to, from_ in prerequisites:
            adjacentList[from_].append(to)
            indegree[to] += 1
        for idx, d in enumerate(indegree):
            if not d: q.appendleft(idx)
        while q:
            count += 1
            course = q.pop()
            for nextCourse in adjacentList[course]:
                indegree[nextCourse] -= 1
                if not indegree[nextCourse]: q.appendleft(nextCourse)
        return count == numCourses