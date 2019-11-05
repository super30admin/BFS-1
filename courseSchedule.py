class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        indegrees = [0]*numCourses
        queue = []
        for i in range(len(prerequisites)):
            indegrees[prerequisites[i][0]] = indegrees[prerequisites[i][0]] + 1
        for j in range(len(indegrees)):
            if indegrees[j] == 0:
                queue.append(j)
        while len(queue) != 0:
            course = queue.pop(0)
            for i in range(len(prerequisites)):
                if prerequisites[i][1] == course:
                    indegrees[prerequisites[i][0]] -= 1
                    if indegrees[prerequisites[i][0]] == 0:
                        queue.append(prerequisites[i][0])
        for i in range(len(indegrees)):
            if indegrees[i] >0:
                return False
        return True