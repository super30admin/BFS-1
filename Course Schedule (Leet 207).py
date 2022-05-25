# Time Complexity: O(V+E), where V is vertices and E are edges


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        if prerequisites is None or len(prerequisites) == 0:
            return True
        
        indegrees = [0] * numCourses
        di = dict()
        for edge in prerequisites:
            indegrees[edge[0]] += 1
            if edge[1] not in di:
                di[edge[1]] = list()
            di[edge[1]].append(edge[0])
        
        q = list()
        count = 0
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                q.append(i)
                count += 1
        
        if len(q) == 0:
            return False
        
        print(indegrees, di)
        
        while len(q) != 0:
            curr = q.pop(0)
            if curr in di:
                edges = di[curr]
                if len(edges) != 0:
                    for edge in edges:
                        indegrees[edge] -= 1
                        if indegrees[edge] == 0:
                            q.append(edge)
                            count += 1
                            if count == numCourses:
                                return True
        return False