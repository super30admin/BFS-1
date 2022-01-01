from collections import deque
from collections import defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        indegree = [0]*numCourses
        map1=defaultdict(list)
        que=deque()
        
        for edge in prerequisites:
            indegree[edge[0]]+=1
            map1[edge[1]].append(edge[0])
        
        for i in range(len(indegree)):
            if indegree[i]==0:
                que.append(i)
        
        if len(que)==0:
            return False
        
        while que:
            popped=que.popleft()
            children = map1[popped]
            for child in children:
                indegree[child]-=1
                if indegree[child]==0:
                    que.append(child)
        
        # you cant say if the que is empty then all curses can be taken, if there is a cycle and one idependent
        # node then que can be empty but indegree of other courses are not 0
        for i in range(len(indegree)):
            if indegree[i]>0:
                return False
        
        return True
        
        
        
        
     
        