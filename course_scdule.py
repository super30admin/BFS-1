class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses ==0:
            return True
        indegree =[0]* numCourses
        listMap ={}
        q=deque()
        for edge in prerequisites:
            indegree[edge[0]]+=1
            if edge[1] not in listMap:
                listMap[edge[1]]=[]
            listMap[edge[1]].append(edge[0])
        for i in range(numCourses):
            if(indegree[i]==0):
                q.append(i)
        count=0
        while q:
            curr=q.popleft()
            count+=1
            edges=listMap.get(curr)
            if edges:
                for edge in edges:
                    indegree[edge]-=1
                    if(indegree[edge]==0):
                        q.append(edge)
        return count == numCourses
            
                
            
        