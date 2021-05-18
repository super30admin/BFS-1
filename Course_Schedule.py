# class Solution:
#     def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
#         if numCourses ==0:
#             return True
#         indegree =[0]* numCourses
#         listMap ={}
#         q=deque()
#         for edge in prerequisites:
#             indegree[edge[0]]+=1
#             if edge[1] not in listMap:
#                 listMap[edge[1]]=[]
#             listMap[edge[1]].append(edge[0])
#         for i in range(numCourses):
#             if(indegree[i]==0):
#                 q.append(i)
#         count=0
#         print (indegree)
#         print(listMap)
#         while q:
#             curr=q.popleft()
#             count+=1
#             edges=listMap.get(curr)
#             if edges:
#                 for edge in edges:
#                     indegree[edge]-=1
#                     if(indegree[edge]==0):
#                         q.append(edge)
#         return count == numCourses

    

from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        if not numCourses:
            return True
        
        inrange = [0]*numCourses
        hashmap = {}
        for i in prerequisites:
            inrange[i[0]] +=1
            if i[1] not in hashmap:
                hashmap[i[1]] = []
            hashmap[i[1]].append(i[0])
                           
        q = deque()
        for i in range(len(inrange)):
            if inrange[i] == 0:
                q.append(i)
        count = 0
        
        while q:
            course = q.popleft()
            count +=1            
            if course in hashmap:
                edges = hashmap[course]
                if edges:
                    for edge in edges:
                        inrange[edge] -=1
                        if inrange[edge] == 0:
                            q.append(edge)
                
        return count == numCourses
            
        
