class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        from collections import defaultdict
        indegree = [0] * numCourses
        maps = defaultdict(list)
        for i in range(len(prerequisites)):
            indegree[prerequisites[i][0]] += 1
            if prerequisites[i][1] not in maps:
                maps[prerequisites[i][1]] = []

            maps[prerequisites[i][1]].append(prerequisites[i][0])
        # print('indegree',indegree)
        # print('maps',maps)
        from collections import deque
        q = deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
        while q:
            length = len(q)
            popp = q.popleft()
            lis = maps[popp]
            if lis != None:

                for j in maps[popp]:
                    indegree[j] -= 1
                    if indegree[j] == 0:
                        q.append(j)
        for i in range(len(indegree)):
            if indegree[i] != 0:
                return False
        return True