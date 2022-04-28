class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites:
            return True
        
        indegrees = [0]*numCourses
        hashMap = {}
        
        for edge in prerequisites:
            indegrees[edge[0]] += 1
            if edge[1] not in hashMap:
                hashMap[edge[1]] = []
                
            hashMap[edge[1]] = [edge[0]]
            
        
        count = 0
        queue= []
        
        for i in range(numCourses):
            if indegrees[i] == 0:
                queue += [i]
                count += 1
                
        if not queue:
            return False
        
        print(queue)
        while queue:
            curr = queue.pop(0)
            edges = hashMap[curr]
            if edges:
                for edge in edges:
                    indegrees[edge] -= 1
                    if indegrees[edge] == 0:
                        queue += [edge]
                        count += 1
                        
        return count == numCourses