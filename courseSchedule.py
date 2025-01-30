class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # TC : O(v+e)
        # SC : O(v+e) - number of courses + length of prerequisites
        if numCourses == 0 or prerequisites is None:
            return True
        indegree =[0]*numCourses
        adj_list = defaultdict(list)
        for u,v in prerequisites:
            adj_list[v].append(u)
            indegree[u] += 1
        q = deque()
        coursesCompleted = 0
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
        while q:
            curcourse = q.popleft()
            coursesCompleted += 1
            edges = adj_list[curcourse]
            if edges == None:
                continue
            for edge in edges:
                indegree[edge] -= 1
                if indegree[edge] == 0:
                    q.append(edge)
        return coursesCompleted == numCourses
        