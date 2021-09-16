class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if prerequisites is None or len(prerequisites ) == 0:
            return True
        indegree = [0]*numCourses
        maps = {}
        for edge in prerequisites:#i in range(len(prerequisites))
            print(edge[0])
            indegree[edge[0]] = indegree[edge[0]] + 1
            if edge[1] not in maps.keys():
                maps[edge[1]] = []
            maps[edge[1]].append(edge[0])
        que = deque([])
        for i, indeg in enumerate(indegree):
            if indeg == 0:
                que.append(i)
                
        # CHeck if queue is empty
        if len(que) <= 0:
                return False
        cnt = 0
        while (len(que) > 0):
            course = que.popleft()
            cnt = cnt + 1
            depedency = maps.get(course)
            if depedency is not None:
                for dep in depedency:
                    indegree[dep] = indegree[dep] -  1
                    if indegree[dep] == 0:
                        que.append(dep)
        return numCourses == cnt
