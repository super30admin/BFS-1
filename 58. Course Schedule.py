# Time Complexity: O(V+E)
# Space Complexity: O(V+V)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        hashmap = {}
        indegrees = [0]*numCourses
        for edges in prerequisites:
            indegrees[edges[0]] += 1
            
            if edges[1] not in hashmap:
                hashmap[edges[1]] = []
            hashmap.get(edges[1]).append(edges[0])
        # print(indegrees)
        # print(hashmap)
        
        queue = []
        count = 0
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                queue.append(i)
                count += 1
        # print(queue)
        
        while len(queue) != 0:
            current = queue.pop(0)
            edges = hashmap.get(current)
            if edges != None:
                for edge in edges:
                    indegrees[edge] -= 1
                    if indegrees[edge] == 0:
                        queue.append(edge)
                        count += 1
        if count == numCourses: return True
        else: False