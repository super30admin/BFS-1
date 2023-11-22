class Solution:
    def canFinish(self, numCourses, prerequisites):
        in_degree = [0 for i in range(numCourses)]
        adj = {i:[] for i in range(numCourses)}

        for crs, pre in prerequisites:
            adj[crs].append(pre)
            in_degree[pre] += 1
        
        q = collections.deque()
        for i in range(numCourses):
            if in_degree[i] == 0:
                q.append(i)
        
        nodeVisited = 0
        while q:
            for _ in range(len(q)):
                node = q.popleft()
                nodeVisited += 1

                for neigh in adj[node]:
                    in_degree[neigh] -= 1
                    if in_degree[neigh] == 0:
                        q.append(neigh)
        return nodeVisited == numCourses
