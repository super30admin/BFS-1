class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = [[] for _ in range(numCourses)]
        for a, b in prerequisites:
            graph[b].append(a)

        visit = [0] * numCourses  # 0=unvisited, 1=visiting, 2=done

        def dfs(c):
            if visit[c] == 1:
                return False
            if visit[c] == 2:
                return True

            visit[c] = 1
            for nxt in graph[c]:
                if not dfs(nxt):
                    return False
            visit[c] = 2
            return True

        for i in range(numCourses):
            if not dfs(i):
                return False
        return True