#Getting runtime error while executing this code please check. Thanks

from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        hashmap={}
        if prerequisites==None or len(prerequisites)==0:
            return True
        indegrees=[0 for _ in range(numCourses)]
        for prereq in prerequisites:
            if prereq[1] not in hashmap:
                hashmap[prereq[1]]=[prereq[0]]
            else:
                hashmap[prereq[1]].append(prereq[0])
            indegrees[prereq[0]]+=1
           
        q=deque([])
        count=0
        for i in range(numCourses):
            if indegrees[i]==0:
                q.append(i)
                count+=1
        while q:
            currCourse=q.popleft()
            for dependents in hashmap[currCourse]:
                # print(dependents)
                indegrees[dependents]-=1
                if indegrees[dependents]==0:
                    q.append(dependents)
                    count+=1
                    if count==numCourses:
                        return True
        return False
                    
                
                
        
            