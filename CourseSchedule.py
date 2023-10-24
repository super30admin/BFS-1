class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        res = {i: [] for i in range(numCourses)}
        for row in prerequisites:
            res[row[1]].append(row[0])
        visited = set()

        def helper(course, visited):
            if course in visited: return False
            if res[course] == []: return True
            visited.add(course)
            for classes in res[course]:
                if not helper(classes, visited): return False
            visited.remove(course)
            res[course] = []
            return True

        for course, pre in prerequisites:
            if not helper(pre, visited): return False
        return True





 