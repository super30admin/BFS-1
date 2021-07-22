from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        if len(prerequisites)==0:
            return True
        #Create Adjacency list
        adjaList=dict()
        
        #Create Indegree Array
        indegree=[0]*numCourses
        
        #Fill both
        for course,prereq in prerequisites:
            if prereq not in adjaList:
                adjaList[prereq]=[]
            adjaList[prereq].append(course)
            indegree[course]+=1
        
        #Add a queue to store all the elements who have indegree 0
        #If there is no element with indegree=0, then there is a cycle and 
        #we will not be able to do Topological sort
        #Also, Topological sort cannot be done in undirected graph
        queue=deque()
        count=0
        for i in range(numCourses):
            if indegree[i]==0:
                queue.append(i)
        if len(queue)==numCourses:
            return True
        if len(queue)==0:
            return False
        while(len(queue)>0):
            v=queue.popleft()
            count+=1
            if v in adjaList:
                for course in adjaList[v]:
                    #reduce the indegree val as already process one node(v) pointing to course
                    indegree[course]-=1
                    if indegree[course]==0:
                        queue.append(course)
            
            
        return count==numCourses
        #Time O(V+E)
        
        #Space O(V+E)
        
        
        
#         def dfsCycle(course,visited, adjList,cur):
            
#             if course in visited:
#                 return True
#             visited[course]=True
            
#             for child in adjList[course]:
#                 if child not in adjList:
#                     continue
#                 if child in visited:
#                     return True
                
#                 if dfsCycle(child,visited,adjList,cur+[course]):
#                     return True
            
#             return False
        
#         adjList=dict()
#         for course,prereq in prerequisites:
#             if prereq not in adjList:
#                 adjList[prereq]=[course]
#             else:
#                 adjList[prereq].append(course)
#         print(adjList)
#         for i in range(numCourses):
#             if i not in adjList:
#                 continue
#             if dfsCycle(i,dict(),adjList,[]):
#                 return False
#         return True
