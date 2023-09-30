# TC: O(m+n) - adj list takes O(m) time to make and indegrees take O(n)
# SC: O(m+n) - adj list takes m space(edges) and indegrees array takes n nodes space
class Solution:
    def canFinish(self, numCourses, prerequisites):
        if not numCourses:
            return True
        indegrees, adjList = [0]*numCourses, {}
        count = 0

        for preReq in prerequisites:
            to, fromm = preReq[0], preReq[1]
            indegrees[to] += 1
            if fromm not in adjList:
                adjList[fromm] = []
            adjList[fromm].append(to)
        q = collections.deque()
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                q.append(i)
                count += 1
        if not q:
            return False
        while q:
            curr = q.popleft()
            edges = adjList.get(curr, None)
            if not edges:
                continue
            for edge in edges:
                indegrees[edge] -= 1
                if indegrees[edge] == 0:
                    q.append(edge)
                    count += 1
        # for i in range(len(indegrees)):
        #     if indegree[i] != 0:
        #         return False
        return count == numCourses
