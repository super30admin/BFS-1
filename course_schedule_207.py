class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # indegree =[0]*numCourses
        # adj= defaultdict(list)

        # for i in prerequisites:
        #     adj[i[1]].append(i[0])
        #     indegree[i[0]]+=1

        # q= []

        # for i in adj:
        #     if indegree[i]==0:
        #         q.append(i)

        # visited= 0

        # while q:
        #     cur = q.pop(0)
        #     visited+=1
        #     for i in adj[cur]:
        #         indegree[i]-=1
        #         if indegree[i]==0:
        #             q.append(i)

        # return numCourses == visited

        indegree = [0] * numCourses
        adj = [[] for x in range(numCourses)]

        for prereq in prerequisites:
            adj[prereq[1]].append(prereq[0])
            indegree[prereq[0]] += 1

        queue = deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)

        visited = 0
        seen = set()
        while queue:
            node = queue.pop()
            visited += 1
            seen.add(node)
            for neighbor in adj[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    queue.append(neighbor)
        print(seen)

        return numCourses == visited
