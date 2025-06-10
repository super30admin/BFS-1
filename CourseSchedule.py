from typing import List, Deque
import collections

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        hashMap = {} #hashmap of independent and dependents
        indegree = [0]*numCourses
        for edges in prerequisites:
            out = edges[1]
            inedges = edges[0]
            if out not in hashMap:
                hashMap[out]=[]
            hashMap.get(out).append(inedges)
            indegree[inedges]+=1
        #start processing the indegree 0 in a queue all do bfs also count so that we know courses taken
        q ,count = collections.deque() , 0
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
                count+=1
        while q:
            curr = q.popleft()
            children = hashMap.get(curr)
            if children:
                for child in children:
                    indegree[child]-=1
                    if indegree[child] == 0:
                        q.append(child)
                        count+=1
                    if count == numCourses:
                        return True
        if count == numCourses: return True
        return False
                    
        

        
            
