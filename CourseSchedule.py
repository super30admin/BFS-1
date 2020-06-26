from queue import Queue
from collections import defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees=[0]*numCourses
        map1={}
        for i in prerequisites:
            indegrees[i[0]]+=1
            if i[1] not in map1:
                map1[i[1]]=[]
        map1.get(i[1]).append(i[0])
        q=Queue()
        for i in range(len(indegrees)):
            if indegrees[i]==0:
                q.put(i)
        while(not(q.empty)):
            curr=q.get()
            children=map.get(curr)
            if children!=None:
                for child in children: 
                    indegrees[child]-=1
                    if indegrees[child]==0:
                        q.put(child)
        for i in range(len(indegrees)):
            if indegrees[i]>0:
                return False
            
        return True
 Time complexity is O(V+E)
 Space is O(n) because of Hashmap
