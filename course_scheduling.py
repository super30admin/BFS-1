#Approach: BFS - tOPOLOGICAL SORT
#Time Complexity : O(V + E) WHERE V is courses and E is dependencies
#Space Complexity : O(V + E)

from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0]*numCourses
        pre_map = {}
        
        if prerequisites ==[] or len(prerequisites) == 0: return True
        for edge in prerequisites:
            indegree[edge[0]]+=1
            
            if edge[1] not in pre_map.keys():
                pre_map[edge[1]] = list()
            
            pre_map[edge[1]].append(edge[0])
        
        queue = deque()
        count = 0
        
        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(i)
                count += 1
                
        if(len(queue) == 0): return False
        
        while(len(queue) != 0):
            key = queue.popleft()
            if key in pre_map.keys():
                edges = pre_map[key]
                if edges != None:
                    for x in edges:
                        indegree[x]-=1
                        if indegree[x] == 0:
                            queue.append(x)
                            count+=1
                            if count == numCourses:
                                return True
        return False
