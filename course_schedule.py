class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0:
            return True
        
        q = deque()
        indegrees = [0] * numCourses
        Map = {} 
        count = 0

        for pre in prerequisites:
            From, to = pre[1], pre[0]
            indegrees[to] += 1
            if From not in Map:
                Map[From] = []
            Map[From].append(to)

        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)
                count += 1

        if count == 0:
            return False 

        while q:
            curr = q.popleft()
            if curr in Map:
                for edge in Map[curr]:
                    indegrees[edge] -= 1
                    if indegrees[edge] == 0:
                        q.append(edge)
                        count += 1

        return count == numCourses
# time - O(numCourses + len(prerequisites))
# space - O(numCourses + len(prerequisites))