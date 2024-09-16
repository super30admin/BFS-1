#LC 207 - Course Schedule
#Time Complexity - O(V + E)
#Space Complexity - O(V + E)
from collections import defaultdict
from collections import deque
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if not numCourses or not prerequisites:
            return True
        d = defaultdict(list)
        indegree = [0]*numCourses
        for i in prerequisites:
            indegree[i[0]] = indegree[i[0]] + 1
            d[i[1]].append(i[0])
        q = deque()
        for i in range(len(indegree)):
            if indegree[i] == 0:
                q.append(i)
        if len(q) == 0:
            return False
        count = 0
        while q:
            course = q.popleft()
            count = count + 1
            for i in d[course]:
                indegree[i] = indegree[i] - 1
                if indegree[i] == 0:
                    q.append(i)
        return count == numCourses